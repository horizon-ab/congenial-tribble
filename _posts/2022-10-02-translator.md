---
title: Translator
description: Use of Google Translate API to create an English-to-Spanish translator
toc: true
comments: true
layout: post
permalink: /fun/translator
categories: [markdown]
author: Bailey Say
---

<title>Translator</title>

<body>
    <div class = "description">
        <p>Please type in the below and press the "translate" button to translate any message from English to Spanish.</p>
    </div>
    <div class = "input">
        <label>Enter English here: </label>
        <input type="text" id="inputField"><br><br>
        <button onclick="translate()">Translate!</button><br><br>
    </div>
    <div>
        <p>Spanish:</p>
        <p id = "output"></p>
    </div>
</body>

<script>

    encodedParams = new URLSearchParams();
    encodedParams.append("target", "es");
    encodedParams.append("source", "en");

    function translate() {
        originalText = document.getElementById("inputField").value;
        encodedParams.append("q", originalText);

        const options = {
            method: 'POST',
            headers: {
                'content-type': 'application/x-www-form-urlencoded',
                'Accept-Encoding': 'application/gzip',
                'X-RapidAPI-Key': '',
                'X-RapidAPI-Host': 'google-translate1.p.rapidapi.com'
            },
            body: encodedParams
        };

        fetch('https://google-translate1.p.rapidapi.com/language/translate/v2', options)
            .then(response => response.json().then(data => {
                console.log(data);

                document.getElementById("output").value = data.translations[0];
            }))
            .then(response => console.log(response))
            .catch(err => console.error(err));

        }
    
</script>