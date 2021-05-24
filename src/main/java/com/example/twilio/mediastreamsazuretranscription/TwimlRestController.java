package com.example.twilio.mediastreamsazuretranscription;

import com.twilio.twiml.VoiceResponse;
import com.twilio.twiml.voice.Pause;
import com.twilio.twiml.voice.Say;
import com.twilio.twiml.voice.Start;
import com.twilio.twiml.voice.Stream;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TwimlRestController {

    @PostMapping(value = "/twiml", produces = "application/xml")
    @ResponseBody
    public String getStreamsTwiml() {

        String wssUrl = "WEBSOCKET_URL";

        return new VoiceResponse.Builder()
            .say(new Say.Builder("Hello! Start talking and the live audio will be streamed to your app").build())
            .start(new Start.Builder().stream(new Stream.Builder().url(wssUrl).build()).build())
            .pause(new Pause.Builder().length(30).build())
            .build().toXml();
    }
}
