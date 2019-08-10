package com.mwojnar.GameObjects;

import com.mwojnar.Assets.AssetLoader;
import com.playgon.GameEngine.ControllerEvent;
import com.playgon.GameEngine.Entity;
import com.playgon.GameEngine.TouchEvent;
import com.playgon.GameWorld.GameWorld;

import java.util.List;

public class TitleScreen extends Entity {
    private int timer = 360;

    public TitleScreen(GameWorld myWorld) {
        super(myWorld);
        setSprite(AssetLoader.spriteTitle);
        setScale(1080.0f / 1920.0f);
    }

    @Override
    public void update(float delta, List<TouchEvent> touchEventList, List<Character> charactersTyped, List<Integer> keysFirstDown, List<Integer> keysFirstUp, List<Integer> keysDown, List<ControllerEvent> controllerEvents) {
        super.update(delta, touchEventList, charactersTyped, keysFirstDown, keysFirstUp, keysDown, controllerEvents);

        timer--;
        if (timer <= 0) {
            transition();
            return;
        }

        for (TouchEvent touchEvent : touchEventList) {
            if (touchEvent.type == TouchEvent.Type.TOUCH_UP) {
                transition();
                return;
            }
        }
    }

    private void transition() {
        destroy();

        Question talkbot14 = new Question("\"Have fun!\" Get out there and \"Just Talk!\"", "", "", null, null, true, -1);
        Question talkbot13 = new Question("\"Don't give out any personal information\"", "", "", talkbot14, null, false, -1, false, true);
        Question talkbot12 = new Question("\"Don't be rude!\" - JusTalk is an open space for everyone, no matter who they are! Any discrimination or hate speech will result in an \"INSTANT BAN\"", "", "", talkbot13, null, false, -1, false, true);
        Question talkbot1 = new Question("Great! I love your enthusiasm! Here are some guidelines before we get started.", "", "", talkbot12, null, false, -1, false, true);
        Question talkbot2 = new Question("Okay! Let's get started Here are some guidelines before we get started.", "", "", talkbot12, null, false, -1, false, true);
        Question talkbotIntro2 = new Question("//Please reply to continue//", "YEAH!", "yeah.", talkbot1, talkbot2, false, -1);
        Question talkbotIntro = new Question("Hello! Welcome to \"JusTalk!\" A space where you can talk to anyone, anywhere! Make friends, meet new people, it's all fine! I'm \"Talkbot\", here to help you get started.", "", "", talkbotIntro2, null, false, -1, false, true);
        talkbotIntro.setPersonName("TalkBot");

        Question KatlantaGoodEnd = new Question("thanks :) anyway, I should be heading off to bed. It was a long day. I feel a bit better though. Thanks again. Take care", "", "", null, null, true, 0);
        Question KatlantaBadEnd = new Question("seriously??? I haven't had a day off in a WEEK and you're all \"oh you should just suck it up and keep working until you keel over\"? F you. Jerk", "", "", null, null, true, 1);
        Question Katlanta12 = new Question("I just want one day for myself, is that too much to ask?", "yeahh", "", KatlantaGoodEnd, null, false, -1);
        Question Katlanta1 = new Question("I KNOW! I only get one day off a week if I'm lucky, and I'm already behind on a lot of stuff.", "", "", Katlanta12, null, false, -1, false, true);
        Question Katlanta2 = new Question("I know, right? Like, that's MY TIME. I just want to sleep. I barely get enough as it is.", "yea!!", "yea...", Katlanta1, KatlantaBadEnd, false, -1);
        Question Katlanta3 = new Question("ugh. you think I'm overreacting, don't you? *sigh* everyone's been saying that and that I \"need to be a team player\" and I just want to scream at them that I want to SLEEP.", "yea!!", "yea...", Katlanta1, KatlantaBadEnd, false, -1);
        Question Katlanta4 = new Question("sweet, thanks. So like, my boss keeps calling me in on my days off because this other girl happens to be \"soooooo sick\" even though we all know she's just hungover.", "yeah...", "yeah??", Katlanta3, Katlanta2, false, -1);
        Question Katlanta5 = new Question("yeah, so like my boss called me in ON MY DAY OFF and made me work a freaking DOUBLE because \"oh no, we're short staffed, and Shelly's sick, and you need to come in\" and all that bullcrap", "yeah...", "yeah??", Katlanta3, Katlanta2, false, -1);
        Question Katlanta62 = new Question("So anyway, I'm pretty sure I had the absolute worst day. like i'm seeing red and stuff", "yea?", "", Katlanta5, null, false, -1);
        Question Katlanta6 = new Question("Uh, okay...", "", "", Katlanta62, null, false, -1, false, true);
        Question KatlantaIntro2 = new Question("You cool if I just vent? I just wanna scream", "YEAH!!", "yeah", Katlanta6, Katlanta4, false, -1);
        Question KatlantaIntro = new Question("Hey", "hey", "", KatlantaIntro2, null, false, -1, true, false);
        KatlantaIntro.setPersonName("Katlanta");

        Question coolguyGoodEnd2 = new Question("see ya", "", "", null, null, true, 0);
        Question coolguyGoodEnd = new Question("thanks man.  I'm glad I got this off my chest", "", "", coolguyGoodEnd2, null, false, -1, false, true);
        Question coolguyBadEnd3 = new Question("you're just like the others. Baka", "", "", null, null, true, 1);
        Question coolguyBadEnd2 = new Question("I met the love of my life and you're just gonna rain on my parade.", "", "", coolguyBadEnd3, null, false, -1, false, true);
        Question coolguyBadEnd = new Question("why do you gotta be so judgemental!?", "", "", coolguyBadEnd2, null, false, -1, false, true);
        Question coolguy1 = new Question("who cares if she can't talk... or that she's a pillow.  She's the love of my life, dangit!", "y..yeah..", "yea", coolguyBadEnd, coolguyGoodEnd, false, -1);
        Question coolguy2 = new Question("i mean, she's beautiful, smart, and totally loves me back! What's not to love about her?", "y..yeah..", "yeah!", coolguyBadEnd, coolguy1, false, -1);
        Question coolguy3 = new Question("Exactly! Sakura-chan and I are in LOVE! We're gonna get married and there's not a damn thing anyone is gonna do about it!", "y..yeah..", "yeah!", coolguyBadEnd, coolguy1, false, -1);
        Question coolguy4 = new Question("oh, so you understand me! we're brothers in arms! comrades!", "yeah??", " YEAH!", coolguy2, coolguy3, false, -1);
        Question coolguy5 = new Question("I mean, there's nothing wrong with it, right?", "yeah", "yeah??", coolguy4, coolguy2, false, -1);
        Question coolguy6 = new Question("yeah, so like, i'm in a relationship, and i'm pretty happy, but they just don't understand!", "yeah", "yea..?", coolguy4, coolguy5, false, -1);
        Question coolguyIntro2 = new Question("so, I don't think my family understands me", "yeah?", "", coolguy6, null, false, -1);
        Question coolguyIntro = new Question("yo", "yo", "", coolguyIntro2, null, false, -1, true, false);
        coolguyIntro.setPersonName("coolguy");

        Question notamartianGoodEnd12 = new Question("But be mindful of your words towards other humans in the future!", "", "", null, null, true, 0);
        Question notamartianGoodEnd1 = new Question("I thought so, comrade. I accept your expression of your regrets towards harming my emotions.", "", "", notamartianGoodEnd12, null, false, -1, false, true);
        Question notamartianGoodEnd2 = new Question("Indeed. I surely hope that doesn't happen in the next few days. Either way, thank you for the pleasant conversation comrade human.", "", "", null, null, true, 0);
        Question notamartianGoodEnd32 = new Question("Now I must excuse myself, comrade, as I go adjust \"plans\" I had for tomorrow.", "", "", null, null, true, 0);
        Question notamartianGoodEnd3 = new Question("CURSES! Uh...I mean...what a pleasant revelation, comrade human! Good to know that we'd be safe in such dangerous circumstances.", "", "", notamartianGoodEnd32, null, false, -1, false, true);
        Question notamartianBadEnd = new Question("Curses! I've been found out! I must report to the mothership immediately!", "", "", null, null, true, 1);
        Question notamartian1 = new Question("Nonsense, comrade! I take offense at that accusation! Would an alien say that humans have the most pleasant flesh-bottoms?", "Yeah", "Yeah...", notamartianBadEnd, notamartianGoodEnd1, false, -1);
        Question notamartian2 = new Question("What?! You doubt my loyalty to my fellow humans?! Do you think me to be an interstellar alien?! Would you flesh-sack be so audacious?!", "YEAH!", "Yeah...", notamartian1, notamartianGoodEnd1, false, -1);
        Question notamartian3 = new Question("Yes! Indeed! Like our most powerful leaders who protect and lead us. We would be defenseless if they were to suddenly be kidnapped by evil space creatures, correct?", "yeah", "yeah?", notamartianGoodEnd2, notamartianGoodEnd3, false, -1);
        Question notamartianIntro2 = new Question("So, comrade, us humans are wonderful creatures, are we not?", "Yeah?", "Yeah!", notamartian2, notamartian3, false, -1);
        Question notamartianIntro = new Question("Greetings, fellow homo sapien!", "Uh...hi?", "", notamartianIntro2, null, false, -1, true, false);
        notamartianIntro.setPersonName("notamartian");

        /*Question firstQuestion = new Question("This is a test question.  Feel free to give an answer.", "Yeah...", "Yeah!",
				new Question("You picked the answer on the left.", "Yeah.", "Yeah?",
						new Question("You picked the answer on the left 2 times.  Ending conversation.", "Yeah", "Yeah", null, null, true, 0),
						new Question("You picked the answer on the left, then the answer on the right.  Ending conversation.", "Yeah", "Yeah", null, null, true, 0),
						false, -1),
				new Question("You picked the answer on the right.", "Yeah.", "Yeah?",
						new Question("You picked the answer on the right, then the answer on the left.  Ending conversation.", "Yeah", "Yeah", null, null, true, 0),
						new Question("You picked the answer on the right 2 times.  Ending conversation.", "Yeah", "Yeah", null, null, true, 0),
						false, -1),
				false, -1, false, false);*/
        ConversationHandler handler = new ConversationHandler(getWorld(), new Question[] {talkbotIntro, KatlantaIntro, coolguyIntro, notamartianIntro});
        getWorld().createEntity(handler);
		/*TextBubble testText = new TextBubble(this, AssetLoader.blueTextBubbleTexture, 75, 300, -115);
		testText.setText("This is a test.");
		testText.setPos(new Vector2(0, 450), false);
		createEntity(testText);
		testText = new TextBubble(this, AssetLoader.greenTextBubbleTexture, 75, 300, -115);
		testText.setText("This is a longer test.  A testier test, if you will.  This will test what a longer message looks like.");
		testText.setPos(new Vector2(getGameDimensions().x - 340, 550), false);
		createEntity(testText);*/
        Entity textingUI = new Entity(getWorld());
        textingUI.setDepth(100000);
        textingUI.setSprite(AssetLoader.spriteTextingUI);
        textingUI.setScale(1080.0f / 1920.0f);
        textingUI.setPivot(0, 0);
        getWorld().createEntity(textingUI);
    }
}
