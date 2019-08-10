package com.mwojnar.Assets;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.*;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.utils.Array;
import com.mwojnar.Game.GMTKGame;
import com.mwojnar.GameEngine.GMTKMusicHandler;
import com.mwojnar.GameEngine.GMTKMusicTemplate;
import com.playgon.GameEngine.BackgroundTemplate;
import com.playgon.GameEngine.MusicTemplate;
import com.playgon.GameEngine.PlaygonSoundManager;
import com.playgon.GameEngine.Sound;
import com.playgon.GameEngine.SoundGroup;
import com.playgon.GameEngine.Sprite;
import com.playgon.Utils.Pair;

public class AssetLoader {

	public static boolean loaded = false, isPlayingMusic = true, isDisplayingHUD = true;
	public static AssetManager assetManager;
	private static TextureAtlas atlas, atlas2;
	public static Texture wojworksTexture;
	public static TextureRegion greenTextBubbleTexture, textingUITexture, blueTextBubbleTexture,
								buttonTexture, buttonPressedTexture, ellipseTexture,
								buttonGrayTexture, titleTexture, endGoodTexture, endBadTexture;
	public static List<TextureRegion> loonyTileTextures = new ArrayList<TextureRegion>(),
						floatyTileTextures = new ArrayList<TextureRegion>(),
						paintTileTextures = new ArrayList<TextureRegion>(),
						bayouTileTextures = new ArrayList<TextureRegion>(),
						surrealTileTextures = new ArrayList<TextureRegion>(),
						grittyTileTextures = new ArrayList<TextureRegion>(),
						bizTileTextures = new ArrayList<TextureRegion>();
	public static TextureRegion greenTexture, blackTexture, whiteTexture;
	public static Sprite spriteGreenTextBubble, spriteTextingUI, spriteBlueTextBubble,
						 spriteEllipse, spriteTitle, spriteEndGood, spriteEndBad;
	public static Sprite spriteGreen, spriteBlack, spriteWhite;
	//public static BackgroundTemplate loony3Background;
	public static Sound soundUICancel, soundUICheckbox, soundUILoadingLoop, soundUIPausing, soundUISelect,
						soundUIUncheckbox, soundUIUnpausing, soundBossCigarSmoking, soundBossCigarSucking,
						soundBossCigarBlowingSmokeBuff, soundMattressDownLong, soundMattressDownShort,
						soundTeleportLoop, soundWaterLoop, soundWaterfall, soundGameShowRight, soundGameShowWrong,
						soundPlayerDeath, soundPlayerDeathUnderwater, soundGameShowRight2;
	public static Sound soundDrumroll, soundBossBombDrop, soundBossBombExplode, soundBossBombFuse,
						soundBossFistChainDrop, soundBossFistChainUp, soundBossFistPound,
						soundBossLaserCharge, soundBossLaserFire, soundBossMissileExplode, soundBossMissileLaunch,
						soundBossPoundTelegraph, soundBossPound, soundBossWeaponDraw, soundEnemyFire,
						soundUnlockSkin, soundBossPoundWhoosh;
	public static SoundGroup sndGrpBalloonPopping, sndGrpCloudPlatformDissappear, sndGrpCloudPlatformWeaker,
						sndGrpEndBalloonExploding, sndGrpEndBalloonPumping, sndGrpGoldenGumball, sndGrpPlayerBouncing,
						sndGrpPlayerBouncingRubber, sndGrpPlayerCollectGumball, sndGrpPlayerDestroyingRock,
						sndGrpPlayerStickingToGooWall, sndGrpPlayerUnstickingFromGooWall, sndGrpPlayerWhooshLarge,
						sndGrpPlayerWhooshSmall, sndGrpRobotDeath, sndGrpRobotTakeHit1, sndGrpRobotTakeHit2,
						sndGrpBossCigarBlowingSmoke, sndGrpCannonFireLightingOil, sndGrpCannonGooeySplattering,
						sndGrpCannonLoadingPlayer, sndGrpCannonOilSplattering, sndGrpCannonShootingFireball,
						sndGrpCannonShootingGooeyball, sndGrpCannonShootingOilball, sndGrpCannonShootingPlayer,
						sndGrpCushionSpikesDown, sndGrpCushionSpikesUp,
						sndGrpMattressBounceLong, sndGrpMattressBounceShort, sndGrpPaintDripping,
						sndGrpPlayerEnteringCottonCandy, sndGrpPlayerGrabbingVine, sndGrpPlayerHittingBongo,
						sndGrpPlayerHittingCushion, sndGrpPlayerMovingInCottonCandy, sndGrpPlayerLeavingCottonCandy,
						sndGrpSignTurning, sndGrpSmallPaintSplash, sndGrpSplashIntoWater, sndGrpSplashOutOfWater,
						sndGrpPlayerSwimming, sndGrpTeleport1, sndGrpTeleport2, sndGrpTeleport3, sndGrpTrashBagPopping,
						sndGrpTrashBursting, sndGrpTrashCanLidHit, sndGrpTrashRumbling, sndGrpPlayerHit,
						sndGrpPlayerHitUnderwater, sndGrpTorpedoLaunching, sndGrpTorpedoExploding;
	public static GMTKMusicTemplate musicMain;
	public static BitmapFont font, shadow, whiteFont;
	public static GMTKMusicHandler musicHandler;
	public static List<Pair<String, Sprite>> spriteList = new ArrayList<Pair<String, Sprite>>();
	public static List<Pair<String, BackgroundTemplate>> backgroundList = new ArrayList<Pair<String, BackgroundTemplate>>();
	public static List<Pair<String, MusicTemplate>> musicList = new ArrayList<Pair<String, MusicTemplate>>();
	public static BitmapFont debugFont = new BitmapFont(true), buttonFont = new BitmapFont(true),
							 debugFontItalics = new BitmapFont(true);
	/*public static Color greenTextColor = new Color(52.0f / 255.0f, 217.0f / 255.0f, 34.0f / 255.0f, 1.0f),
			menuTextDefaultColor = new Color(77.0f / 255.0f, 207.0f / 255.0f, 228.0f / 255.0f, 1.0f),
			loonyMenuTextColor = new Color(230 / 255.0f,223 / 255.0f,77 / 255.0f, 1.0f),
			paintMenuTextColor = new Color(136 / 255.0f,228 / 255.0f,242 / 255.0f, 1.0f),
			floatyMenuTextColor = new Color(197 / 255.0f,28 / 255.0f,192 / 255.0f, 1.0f),
			boMenuTextColor = new Color(180 / 255.0f,218 / 255.0f,131 / 255.0f, 1.0f),
			surrealMenuTextColor = new Color(143 / 255.0f,143 / 255.0f,143 / 255.0f, 1.0f),
			grittyMenuTextColor = new Color(77 / 255.0f,202 / 255.0f,64 / 255.0f, 1.0f),
			bizHQMenuTextColor = new Color(226 / 255.0f,187 / 255.0f,61 / 255.0f, 1.0f);*/
	public static float musicVolume = 0.5f, soundVolume = 1.0f;
	private static PlaygonSoundManager soundManager = new PlaygonSoundManager(15);
	private static final Sound EMPTY_SOUND = GMTKGame.createSound();
	/*public static String soundFileBalloonPopping1 = "data/Sounds/BALLOON_POPPING_1.mp3",
			soundFileBalloonPopping2 = "data/Sounds/BALLOON_POPPING_2.mp3",
			soundFileCloudPlatformDissapear1 = "data/Sounds/CLOUD_PLATFORM_DISSAPEAR_1.mp3",
			soundFileCloudPlatformDissapear2 = "data/Sounds/CLOUD_PLATFORM_DISSAPEAR_2.mp3",
			soundFileCloudPlatformWeaker1 = "data/Sounds/CLOUD_PLATFORM_WEAKER_1.mp3",
			soundFileCloudPlatformWeaker2 = "data/Sounds/CLOUD_PLATFORM_WEAKER_2.mp3",
			soundFileCloudPlatformWeaker3 = "data/Sounds/CLOUD_PLATFORM_WEAKER_3.mp3",
			soundFileEndBalloonExploding = "data/Sounds/END_BALLOON_EXPLODING.mp3",
			soundFileEndBalloonPumping1 = "data/Sounds/END_BALLOON_PUMPING_1.mp3",
			soundFileEndBalloonPumping2 = "data/Sounds/END_BALLOON_PUMPING_2.mp3",
			soundFileEndBalloonPumping3 = "data/Sounds/END_BALLOON_PUMPING_3.mp3",
			soundFileEndBalloonPumping4 = "data/Sounds/END_BALLOON_PUMPING_4.mp3",
			soundFileEndBalloonPumping5 = "data/Sounds/END_BALLOON_PUMPING_5.mp3",
			soundFileEndBalloonPumping6 = "data/Sounds/END_BALLOON_PUMPING_6.mp3",
			soundFileEndBalloonPumping7 = "data/Sounds/END_BALLOON_PUMPING_7.mp3",
			soundFileEndBalloonPumping8 = "data/Sounds/END_BALLOON_PUMPING_8.mp3",
			soundFileEndBalloonPumping9 = "data/Sounds/END_BALLOON_PUMPING_9.mp3",
			soundFileEndBalloonPumping10 = "data/Sounds/END_BALLOON_PUMPING_10.mp3",
			soundFileGoldenGumball1 = "data/Sounds/GOLDEN_GUMBALL_1.mp3",
			soundFileGoldenGumball2 = "data/Sounds/GOLDEN_GUMBALL_2.mp3",
			soundFilePlayerBouncing1 = "data/Sounds/PLAYER_BOUNCING_1.mp3",
			soundFilePlayerBouncing2 = "data/Sounds/PLAYER_BOUNCING_2.mp3",
			soundFilePlayerBouncing3 = "data/Sounds/PLAYER_BOUNCING_3.mp3",
			soundFilePlayerBouncing4 = "data/Sounds/PLAYER_BOUNCING_4.mp3",
			soundFilePlayerBouncing5 = "data/Sounds/PLAYER_BOUNCING_5.mp3",
			soundFilePlayerBouncing6 = "data/Sounds/PLAYER_BOUNCING_6.mp3",
			soundFilePlayerBouncingRubber1 = "data/Sounds/PLAYER_BOUNCING_RUBBER_1.mp3",
			soundFilePlayerBouncingRubber2 = "data/Sounds/PLAYER_BOUNCING_RUBBER_2.mp3",
			soundFilePlayerBouncingRubber3 = "data/Sounds/PLAYER_BOUNCING_RUBBER_3.mp3",
			soundFilePlayerCollectGumball1 = "data/Sounds/PLAYER_COLLECT_GUMBALL_1.mp3",
			soundFilePlayerCollectGumball2 = "data/Sounds/PLAYER_COLLECT_GUMBALL_2.mp3",
			soundFilePlayerCollectGumball3 = "data/Sounds/PLAYER_COLLECT_GUMBALL_3.mp3",
			soundFilePlayerCollectGumball4 = "data/Sounds/PLAYER_COLLECT_GUMBALL_4.mp3",
			soundFilePlayerCollectGumball5 = "data/Sounds/PLAYER_COLLECT_GUMBALL_5.mp3",
			soundFilePlayerCollectGumball6 = "data/Sounds/PLAYER_COLLECT_GUMBALL_6.mp3",
			soundFilePlayerCollectGumball7 = "data/Sounds/PLAYER_COLLECT_GUMBALL_7.mp3",
			soundFilePlayerCollectGumball8 = "data/Sounds/PLAYER_COLLECT_GUMBALL_8.mp3",
			soundFilePlayerDestroyingRockBlock1 = "data/Sounds/PLAYER_DESTROYING_ROCK_BLOCK_1.mp3",
			soundFilePlayerDestroyingRockBlock2 = "data/Sounds/PLAYER_DESTROYING_ROCK_BLOCK_2.mp3",
			soundFilePlayerDestroyingRockBlock3 = "data/Sounds/PLAYER_DESTROYING_ROCK_BLOCK_3.mp3",
			soundFilePlayerDestroyingRockBlock4 = "data/Sounds/PLAYER_DESTROYING_ROCK_BLOCK_4.mp3",
			soundFilePlayerDestroyingRockBlock5 = "data/Sounds/PLAYER_DESTROYING_ROCK_BLOCK_5.mp3",
			soundFilePlayerStickingToGooeWall1 = "data/Sounds/PLAYER_STICKING_TO_GOOE_WALL_1.mp3",
			soundFilePlayerStickingToGooeWall2 = "data/Sounds/PLAYER_STICKING_TO_GOOE_WALL_2.mp3",
			soundFilePlayerStickingToGooeWall3 = "data/Sounds/PLAYER_STICKING_TO_GOOE_WALL_3.mp3",
			soundFilePlayerStickingToGooeWall4 = "data/Sounds/PLAYER_STICKING_TO_GOOE_WALL_4.mp3",
			soundFilePlayerStickingToGooeWall5 = "data/Sounds/PLAYER_STICKING_TO_GOOE_WALL_5.mp3",
			soundFilePlayerUnstickingFromGooeWall1 = "data/Sounds/PLAYER_UNSTICKING_FROM_GOOE_WALL_1.mp3",
			soundFilePlayerUnstickingFromGooeWall2 = "data/Sounds/PLAYER_UNSTICKING_FROM_GOOE_WALL_2.mp3",
			soundFilePlayerWhooshLarge1 = "data/Sounds/PLAYER_WHOOSH_LARGE_1.mp3",
			soundFilePlayerWhooshLarge2 = "data/Sounds/PLAYER_WHOOSH_LARGE_2.mp3",
			soundFilePlayerWhooshLarge3 = "data/Sounds/PLAYER_WHOOSH_LARGE_3.mp3",
			soundFilePlayerWhooshSmall1 = "data/Sounds/PLAYER_WHOOSH_SMALL_1.mp3",
			soundFilePlayerWhooshSmall2 = "data/Sounds/PLAYER_WHOOSH_SMALL_2.mp3",
			soundFilePlayerWhooshSmall3 = "data/Sounds/PLAYER_WHOOSH_SMALL_3.mp3",
			soundFileRobotDeath1 = "data/Sounds/ROBOT_DEATH_1.mp3",
			soundFileRobotDeath2 = "data/Sounds/ROBOT_DEATH_2.mp3",
			soundFileRobotTakeHit11 = "data/Sounds/ROBOT_TAKE_HIT_1_1.mp3",
			soundFileRobotTakeHit12 = "data/Sounds/ROBOT_TAKE_HIT_1_2.mp3",
			soundFileRobotTakeHit21 = "data/Sounds/ROBOT_TAKE_HIT_2_1.mp3",
			soundFileRobotTakeHit22 = "data/Sounds/ROBOT_TAKE_HIT_2_2.mp3",
			soundFileBossCigarBlowingSmoke1 = "data/Sounds/BOSS_CIGAR_BLOWING_SMOKE_1.mp3",
			soundFileBossCigarBlowingSmoke2 = "data/Sounds/BOSS_CIGAR_BLOWING_SMOKE_2.mp3",
			soundFileCannonFireLightingOil1 = "data/Sounds/CANNON_FIRE_LIGHTING_OIL_1.mp3",
			soundFileCannonFireLightingOil2 = "data/Sounds/CANNON_FIRE_LIGHTING_OIL_2.mp3",
			soundFileCannonFireLightingOil3 = "data/Sounds/CANNON_FIRE_LIGHTING_OIL_3.mp3",
			soundFileCannonGooeySplattering1 = "data/Sounds/CANNON_GOOEY_SPLATTERING_1.mp3",
			soundFileCannonGooeySplattering2 = "data/Sounds/CANNON_GOOEY_SPLATTERING_2.mp3",
			soundFileCannonGooeySplattering3 = "data/Sounds/CANNON_GOOEY_SPLATTERING_3.mp3",
			soundFileCannonLoadingPlayerIn1 = "data/Sounds/CANNON_LOADING_PLAYER_IN_1.mp3",
			soundFileCannonLoadingPlayerIn2 = "data/Sounds/CANNON_LOADING_PLAYER_IN_2.mp3",
			soundFileCannonOilSplattering1 = "data/Sounds/CANNON_OIL_SPLATTERING_1.mp3",
			soundFileCannonOilSplattering2 = "data/Sounds/CANNON_OIL_SPLATTERING_2.mp3",
			soundFileCannonOilSplattering3 = "data/Sounds/CANNON_OIL_SPLATTERING_3.mp3",
			soundFileCannonShootingFireball1 = "data/Sounds/CANNON_SHOOTING_FIREBALL_1.mp3",
			soundFileCannonShootingFireball2 = "data/Sounds/CANNON_SHOOTING_FIREBALL_2.mp3",
			soundFileCannonShootingFireball3 = "data/Sounds/CANNON_SHOOTING_FIREBALL_3.mp3",
			soundFileCannonShootingGooeyball1 = "data/Sounds/CANNON_SHOOTING_GOOEYBALL_1.mp3",
			soundFileCannonShootingGooeyball2 = "data/Sounds/CANNON_SHOOTING_GOOEYBALL_2.mp3",
			soundFileCannonShootingGooeyball3 = "data/Sounds/CANNON_SHOOTING_GOOEYBALL_3.mp3",
			soundFileCannonShootingOilball1 = "data/Sounds/CANNON_SHOOTING_OILBALL_1.mp3",
			soundFileCannonShootingOilball2 = "data/Sounds/CANNON_SHOOTING_OILBALL_2.mp3",
			soundFileCannonShootingOilball3 = "data/Sounds/CANNON_SHOOTING_OILBALL_3.mp3",
			soundFileCannonShootingPlayer1 = "data/Sounds/CANNON_SHOOTING_PLAYER_1.mp3",
			soundFileCannonShootingPlayer2 = "data/Sounds/CANNON_SHOOTING_PLAYER_2.mp3",
			soundFileCannonShootingPlayer3 = "data/Sounds/CANNON_SHOOTING_PLAYER_3.mp3",
			soundFileCushionSpikesDown1 = "data/Sounds/CUSHION_SPIKES_DOWN_1.mp3",
			soundFileCushionSpikesDown2 = "data/Sounds/CUSHION_SPIKES_DOWN_2.mp3",
			soundFileCushionSpikesUp1 = "data/Sounds/CUSHION_SPIKES_UP_1.mp3",
			soundFileCushionSpikesUp2 = "data/Sounds/CUSHION_SPIKES_UP_2.mp3",
			soundFileMatressBounceLong1 = "data/Sounds/MATRESS_BOUNCE_LONG_1.mp3",
			soundFileMatressBounceLong2 = "data/Sounds/MATRESS_BOUNCE_LONG_2.mp3",
			soundFileMatressBounceShort1 = "data/Sounds/MATRESS_BOUNCE_SHORT_1.mp3",
			soundFileMatressBounceShort2 = "data/Sounds/MATRESS_BOUNCE_SHORT_2.mp3",
			soundFilePaintDripping1 = "data/Sounds/PAINT_DRIPPING_1.mp3",
			soundFilePaintDripping2 = "data/Sounds/PAINT_DRIPPING_2.mp3",
			soundFilePaintDripping3 = "data/Sounds/PAINT_DRIPPING_3.mp3",
			soundFilePaintDripping4 = "data/Sounds/PAINT_DRIPPING_4.mp3",
			soundFilePaintDripping5 = "data/Sounds/PAINT_DRIPPING_5.mp3",
			soundFilePaintDripping6 = "data/Sounds/PAINT_DRIPPING_6.mp3",
			soundFilePaintDripping7 = "data/Sounds/PAINT_DRIPPING_7.mp3",
			soundFilePlayerEnteringCandyCotton1 = "data/Sounds/PLAYER_ENTERING_CANDY_COTTON_1.mp3",
			soundFilePlayerEnteringCandyCotton2 = "data/Sounds/PLAYER_ENTERING_CANDY_COTTON_2.mp3",
			soundFilePlayerEnteringCandyCotton3 = "data/Sounds/PLAYER_ENTERING_CANDY_COTTON_3.mp3",
			soundFilePlayerGrabbingVine1 = "data/Sounds/PLAYER_GRABBING_VINE_1.mp3",
			soundFilePlayerGrabbingVine2 = "data/Sounds/PLAYER_GRABBING_VINE_2.mp3",
			soundFilePlayerHittingBongo1 = "data/Sounds/PLAYER_HITTING_BONGO_1.mp3",
			soundFilePlayerHittingBongo2 = "data/Sounds/PLAYER_HITTING_BONGO_2.mp3",
			soundFilePlayerHittingBongo3 = "data/Sounds/PLAYER_HITTING_BONGO_3.mp3",
			soundFilePlayerHittingCushion1 = "data/Sounds/PLAYER_HITTING_CUSHION_1.mp3",
			soundFilePlayerHittingCushion2 = "data/Sounds/PLAYER_HITTING_CUSHION_2.mp3",
			soundFilePlayerMovingInCandyCotton1 = "data/Sounds/PLAYER_MOVING_IN_CANDY_COTTON_1.mp3",
			soundFilePlayerMovingInCandyCotton2 = "data/Sounds/PLAYER_MOVING_IN_CANDY_COTTON_2.mp3",
			soundFilePlayerMovingInCandyCotton3 = "data/Sounds/PLAYER_MOVING_IN_CANDY_COTTON_3.mp3",
			soundFilePlayerMovingInCandyCotton4 = "data/Sounds/PLAYER_MOVING_IN_CANDY_COTTON_4.mp3",
			soundFilePlayerOutCandyCotton1 = "data/Sounds/PLAYER_OUT_CANDY_COTTON_1.mp3",
			soundFilePlayerOutCandyCotton2 = "data/Sounds/PLAYER_OUT_CANDY_COTTON_2.mp3",
			soundFilePlayerOutCandyCotton3 = "data/Sounds/PLAYER_OUT_CANDY_COTTON_3.mp3",
			soundFileSignTurning1 = "data/Sounds/SIGN_TURNING_1.mp3",
			soundFileSignTurning2 = "data/Sounds/SIGN_TURNING_2.mp3",
			soundFileSmallPaintSplash1 = "data/Sounds/SMALL_PAINT_SPLASH_1.mp3",
			soundFileSmallPaintSplash2 = "data/Sounds/SMALL_PAINT_SPLASH_2.mp3",
			soundFileSplashInToWater1 = "data/Sounds/SPLASH_IN_TO_WATER_1.mp3",
			soundFileSplashInToWater2 = "data/Sounds/SPLASH_IN_TO_WATER_2.mp3",
			soundFileSplashOutOfWater1 = "data/Sounds/SPLASH_OUT_OF_WATER_1.mp3",
			soundFileSplashOutOfWater2 = "data/Sounds/SPLASH_OUT_OF_WATER_2.mp3",
			soundFileSwingingThroughWater1 = "data/Sounds/SWINGING_THROUGH_WATER_1.mp3",
			soundFileSwingingThroughWater2 = "data/Sounds/SWINGING_THROUGH_WATER_2.mp3",
			soundFileTeleport11 = "data/Sounds/TELEPORT_1_1.mp3",
			soundFileTeleport12 = "data/Sounds/TELEPORT_1_2.mp3",
			soundFileTeleport21 = "data/Sounds/TELEPORT_2_1.mp3",
			soundFileTeleport22 = "data/Sounds/TELEPORT_2_2.mp3",
			soundFileTeleport31 = "data/Sounds/TELEPORT_3_1.mp3",
			soundFileTeleport32 = "data/Sounds/TELEPORT_3_2.mp3",
			soundFileTrashBagPopping1 = "data/Sounds/TRASH_BAG_POPPING_1.mp3",
			soundFileTrashBagPopping2 = "data/Sounds/TRASH_BAG_POPPING_2.mp3",
			soundFileTrashBagPopping3 = "data/Sounds/TRASH_BAG_POPPING_3.mp3",
			soundFileTrashBursting1 = "data/Sounds/TRASH_BURSTING_1.mp3",
			soundFileTrashBursting2 = "data/Sounds/TRASH_BURSTING_2.mp3",
			soundFileTrashBursting3 = "data/Sounds/TRASH_BURSTING_3.mp3",
			soundFileTrashCanLidHit1 = "data/Sounds/TRASH_CAN_LID_HIT_1.mp3",
			soundFileTrashCanLidHit2 = "data/Sounds/TRASH_CAN_LID_HIT_2.mp3",
			soundFileTrashCanLidHit3 = "data/Sounds/TRASH_CAN_LID_HIT_3.mp3",
			soundFileTrashCanLidHit4 = "data/Sounds/TRASH_CAN_LID_HIT_4.mp3",
			soundFileTrashRumbling1 = "data/Sounds/TRASH_RUMBLING_1.mp3",
			soundFileTrashRumbling2 = "data/Sounds/TRASH_RUMBLING_2.mp3",
			soundFileTrashRumbling3 = "data/Sounds/TRASH_RUMBLING_3.mp3",
			soundFilePlayerTakeHit1 = "data/Sounds/PLAYER_TAKE_HIT_1.mp3",
			soundFilePlayerTakeHit2 = "data/Sounds/PLAYER_TAKE_HIT_2.mp3",
			soundFilePlayerTakeHit3 = "data/Sounds/PLAYER_TAKE_HIT_3.mp3",
			soundFilePlayerTakeHitUnderWater1 = "data/Sounds/PLAYER_TAKE_HIT_UNDER_WATER_1.mp3",
			soundFilePlayerTakeHitUnderWater2 = "data/Sounds/PLAYER_TAKE_HIT_UNDER_WATER_2.mp3",
			soundFilePlayerTakeHitUnderWater3 = "data/Sounds/PLAYER_TAKE_HIT_UNDER_WATER_3.mp3",
			soundFileTorpedoLaunching1 = "data/Sounds/TORPEDO_LAUNCHING_1.mp3",
			soundFileTorpedoLaunching2 = "data/Sounds/TORPEDO_LAUNCHING_2.mp3",
			soundFileTorpedoLaunching3 = "data/Sounds/TORPEDO_LAUNCHING_3.mp3",
			soundFileTorpedoExploding1 = "data/Sounds/TORPEDO_EXPLODING_1.mp3",
			soundFileTorpedoExploding2 = "data/Sounds/TORPEDO_EXPLODING_2.mp3",
			soundFileTorpedoExploding3 = "data/Sounds/TORPEDO_EXPLODING_3.mp3",
			soundFileUiCancel = "data/Sounds/UI_CANCEL.mp3",
			soundFileUiCheckBox = "data/Sounds/UI_CHECK_BOX.mp3",
			soundFileUiLoadingLoop = "data/Sounds/UI_LOADING_LOOP.mp3",
			soundFileUiPausing = "data/Sounds/UI_PAUSING.mp3",
			soundFileUiSelect = "data/Sounds/UI_SELECT.mp3",
			soundFileUiUncheckBox = "data/Sounds/UI_UNCHECK_BOX.mp3",
			soundFileUiUnpausing = "data/Sounds/UI_UNPAUSING.mp3",
			soundFileBossCigarSmoking = "data/Sounds/BOSS_CIGAR_SMOKING.mp3",
			soundFileBossCigarSucking = "data/Sounds/BOSS_CIGAR_SUCKING.mp3",
			soundFileBossCigarBlowingSmokeBuff = "data/Sounds/BOSS_CIGAR_BLOWING_SMOKE_BUFF.mp3",
			soundFileMatressDownLong = "data/Sounds/MATRESS_DOWN_LONG.mp3",
			soundFileMatressDownShort = "data/Sounds/MATRESS_DOWN_SHORT.mp3",
			soundFileTeleportLoop = "data/Sounds/TELEPORT_LOOP.mp3",
			soundFileWaterLoop = "data/Sounds/WATER_LOOP.mp3",
			soundFileWaterfall = "data/Sounds/WATERFALL.wav",
			soundFileGameShowRight = "data/Sounds/GAME_SHOW_RIGHT.mp3",
			soundFileGameShowRightVer2 = "data/Sounds/GAME_SHOW_RIGHT_VER2.mp3",
			soundFileGameShowWrong = "data/Sounds/GAME_SHOW_WRONG.mp3",
			soundFilePlayerDeath = "data/Sounds/PLAYER_DEATH.mp3",
			soundFilePlayerDeathUnderWater = "data/Sounds/PLAYER_DEATH_UNDER_WATER.mp3",
			soundFileEndBalloonDrumroll = "data/Sounds/endBalloonDrumroll.mp3",
			soundFileBossBombDropv1 = "data/Sounds/BOSS_BOMB_DROPv1.mp3",
			soundFileBossBombExplodev1 = "data/Sounds/BOSS_BOMB_EXPLODEv1.mp3",
			soundFileBossBombFusev1 = "data/Sounds/BOSS_BOMB_FUSEv1.mp3",
			soundFileBossFistChainDropv1 = "data/Sounds/BOSS_FIST_CHAIN_DROPv1.mp3",
			soundFileBossFistChainUpv1 = "data/Sounds/BOSS_FIST_CHAIN_Upv1.mp3",
			soundFileBossFistPoundv1 = "data/Sounds/BOSS_FIST_POUNDv1.mp3",
			soundFileBossLaserChargev1 = "data/Sounds/BOSS_LASER_CHARGEv1.mp3",
			soundFileBossLaserFirev1 = "data/Sounds/BOSS_LASER_FIREv1.mp3",
			soundFileBossMissileExplodev1 = "data/Sounds/BOSS_MISSILE_EXPLODEv1.mp3",
			soundFileBossMissileLaunchv1 = "data/Sounds/BOSS_MISSILE_LAUNCHv1.mp3",
			soundFileBossPoundTelegraphv1 = "data/Sounds/BOSS_POUND_TELEGRAPHv1.mp3",
			soundFileBossPoundv1 = "data/Sounds/BOSS_POUNDv1.mp3",
			soundFileBossWeaponDrawv1 = "data/Sounds/BOSS_WEAPON_DRAWv1.mp3",
			soundFileEnemyFirev1 = "data/Sounds/ENEMY_FIREv1.mp3",
			soundFileUnlockSkinv1 = "data/Sounds/UNLOCK_SKINv1.mp3",
			soundFileBossPoundWhooshv1 = "data/Sounds/BOSS_POUND_WHOOSHv1.mp3";
	public static String[] sndGrpBalloonPoppingNames = new String[] {
			soundFileBalloonPopping1,
			soundFileBalloonPopping2
	},
	sndGrpCloudPlatformDissappearNames = new String[] {
			soundFileCloudPlatformDissapear1,
			soundFileCloudPlatformDissapear2
	},
	sndGrpCloudPlatformWeakerNames = new String[] {
			soundFileCloudPlatformWeaker1,
			soundFileCloudPlatformWeaker2,
			soundFileCloudPlatformWeaker3
	},
	sndGrpEndBalloonExplodingNames = new String[] {
			soundFileEndBalloonExploding
	},
	sndGrpEndBalloonPumpingNames = new String[] {
			soundFileEndBalloonPumping1,
			soundFileEndBalloonPumping2,
			soundFileEndBalloonPumping3,
			soundFileEndBalloonPumping4,
			soundFileEndBalloonPumping5,
			soundFileEndBalloonPumping6,
			soundFileEndBalloonPumping7,
			soundFileEndBalloonPumping8,
			soundFileEndBalloonPumping9,
			soundFileEndBalloonPumping10
	},
	sndGrpGoldenGumballNames = new String[] {
			soundFileGoldenGumball1,
			soundFileGoldenGumball2
	},
	sndGrpPlayerBouncingNames = new String[] {
			soundFilePlayerBouncing1,
			soundFilePlayerBouncing2,
			soundFilePlayerBouncing3,
			soundFilePlayerBouncing4,
			soundFilePlayerBouncing5,
			soundFilePlayerBouncing6
	},
	sndGrpPlayerBouncingRubberNames = new String[] {
			soundFilePlayerBouncingRubber1,
			soundFilePlayerBouncingRubber2,
			soundFilePlayerBouncingRubber3
	},
	sndGrpPlayerCollectGumballNames = new String[] {
			soundFilePlayerCollectGumball1,
			soundFilePlayerCollectGumball2,
			soundFilePlayerCollectGumball3,
			soundFilePlayerCollectGumball4,
			soundFilePlayerCollectGumball5,
			soundFilePlayerCollectGumball6,
			soundFilePlayerCollectGumball7,
			soundFilePlayerCollectGumball8
	},
	sndGrpPlayerDestroyingRockNames = new String[] {
			soundFilePlayerDestroyingRockBlock1,
			soundFilePlayerDestroyingRockBlock2,
			soundFilePlayerDestroyingRockBlock3,
			soundFilePlayerDestroyingRockBlock4,
			soundFilePlayerDestroyingRockBlock5
	},
	sndGrpPlayerStickingToGooWallNames = new String[] {
			soundFilePlayerStickingToGooeWall1,
			soundFilePlayerStickingToGooeWall2,
			soundFilePlayerStickingToGooeWall3,
			soundFilePlayerStickingToGooeWall4,
			soundFilePlayerStickingToGooeWall5
	},
	sndGrpPlayerUnstickingFromGooWallNames = new String[] {
			soundFilePlayerUnstickingFromGooeWall1,
			soundFilePlayerUnstickingFromGooeWall2
	},
	sndGrpPlayerWhooshLargeNames = new String[] {
			soundFilePlayerWhooshLarge1,
			soundFilePlayerWhooshLarge2,
			soundFilePlayerWhooshLarge3
	},
	sndGrpPlayerWhooshSmallNames = new String[] {
			soundFilePlayerWhooshSmall1,
			soundFilePlayerWhooshSmall2,
			soundFilePlayerWhooshSmall3
	},
	sndGrpRobotDeathNames = new String[] {
			soundFileRobotDeath1,
			soundFileRobotDeath2
	},
	sndGrpRobotTakeHit1Names = new String[] {
			soundFileRobotTakeHit11,
			soundFileRobotTakeHit12
	},
	sndGrpRobotTakeHit2Names = new String[] {
			soundFileRobotTakeHit21,
			soundFileRobotTakeHit22
	},
	sndGrpBossCigarBlowingSmokeNames = new String[] {
			soundFileBossCigarBlowingSmoke1,
			soundFileBossCigarBlowingSmoke2
	},
	sndGrpCannonFireLightingOilNames = new String[] {
			soundFileCannonFireLightingOil1,
			soundFileCannonFireLightingOil2,
			soundFileCannonFireLightingOil3
	},
	sndGrpCannonGooeySplatteringNames = new String[] {
			soundFileCannonGooeySplattering1,
			soundFileCannonGooeySplattering2,
			soundFileCannonGooeySplattering3
	},
	sndGrpCannonLoadingPlayerNames = new String[] {
			soundFileCannonLoadingPlayerIn1,
			soundFileCannonLoadingPlayerIn2
	},
	sndGrpCannonOilSplatteringNames = new String[] {
			soundFileCannonOilSplattering1,
			soundFileCannonOilSplattering2,
			soundFileCannonOilSplattering3
	},
	sndGrpCannonShootingFireballNames = new String[] {
			soundFileCannonShootingFireball1,
			soundFileCannonShootingFireball2,
			soundFileCannonShootingFireball3
	},
	sndGrpCannonShootingGooeyballNames = new String[] {
			soundFileCannonShootingGooeyball1,
			soundFileCannonShootingGooeyball2,
			soundFileCannonShootingGooeyball3
	},
	sndGrpCannonShootingOilballNames = new String[] {
			soundFileCannonShootingOilball1,
			soundFileCannonShootingOilball2,
			soundFileCannonShootingOilball3
	},
	sndGrpCannonShootingPlayerNames = new String[] {
			soundFileCannonShootingPlayer1,
			soundFileCannonShootingPlayer2,
			soundFileCannonShootingPlayer3
	},
	sndGrpCushionSpikesDownNames = new String[] {
			soundFileCushionSpikesDown1,
			soundFileCushionSpikesDown2
	},
	sndGrpCushionSpikesUpNames = new String[] {
			soundFileCushionSpikesUp1,
			soundFileCushionSpikesUp2
	},
	sndGrpMattressBounceLongNames = new String[] {
			soundFileMatressBounceLong1,
			soundFileMatressBounceLong2
	},
	sndGrpMattressBounceShortNames = new String[] {
			soundFileMatressBounceShort1,
			soundFileMatressBounceShort2
	},
	sndGrpPaintDrippingNames = new String[] {
			soundFilePaintDripping1,
			soundFilePaintDripping2,
			soundFilePaintDripping3,
			soundFilePaintDripping4,
			soundFilePaintDripping5,
			soundFilePaintDripping6,
			soundFilePaintDripping7
	},
	sndGrpPlayerEnteringCottonCandyNames = new String[] {
			soundFilePlayerEnteringCandyCotton1,
			soundFilePlayerEnteringCandyCotton2,
			soundFilePlayerEnteringCandyCotton3
	},
	sndGrpPlayerGrabbingVineNames = new String[] {
			soundFilePlayerGrabbingVine1,
			soundFilePlayerGrabbingVine2
	},
	sndGrpPlayerHittingBongoNames = new String[] {
			soundFilePlayerHittingBongo1,
			soundFilePlayerHittingBongo2,
			soundFilePlayerHittingBongo3
	},
	sndGrpPlayerHittingCushionNames = new String[] {
			soundFilePlayerHittingCushion1,
			soundFilePlayerHittingCushion2
	},
	sndGrpPlayerMovingInCottonCandyNames = new String[] {
			soundFilePlayerMovingInCandyCotton1,
			soundFilePlayerMovingInCandyCotton2,
			soundFilePlayerMovingInCandyCotton3,
			soundFilePlayerMovingInCandyCotton4
	},
	sndGrpPlayerLeavingCottonCandyNames = new String[] {
			soundFilePlayerOutCandyCotton1,
			soundFilePlayerOutCandyCotton2,
			soundFilePlayerOutCandyCotton3
	},
	sndGrpSignTurningNames = new String[] {
			soundFileSignTurning1,
			soundFileSignTurning2
	},
	sndGrpSmallPaintSplashNames = new String[] {
			soundFileSmallPaintSplash1,
			soundFileSmallPaintSplash2
	},
	sndGrpSplashIntoWaterNames = new String[] {
			soundFileSplashInToWater1,
			soundFileSplashInToWater2
	},
	sndGrpSplashOutOfWaterNames = new String[] {
			soundFileSplashOutOfWater1,
			soundFileSplashOutOfWater2
	},
	sndGrpPlayerSwimmingNames = new String[] {
			soundFileSwingingThroughWater1,
			soundFileSwingingThroughWater2
	},
	sndGrpTeleport1Names = new String[] {
			soundFileTeleport11,
			soundFileTeleport12
	},
	sndGrpTeleport2Names = new String[] {
			soundFileTeleport21,
			soundFileTeleport22
	},
	sndGrpTeleport3Names = new String[] {
			soundFileTeleport31,
			soundFileTeleport32
	},
	sndGrpTrashBagPoppingNames = new String[] {
			soundFileTrashBagPopping1,
			soundFileTrashBagPopping2,
			soundFileTrashBagPopping3
	},
	sndGrpTrashBurstingNames = new String[] {
			soundFileTrashBursting1,
			soundFileTrashBursting2,
			soundFileTrashBursting3
	},
	sndGrpTrashCanLidHitNames = new String[] {
			soundFileTrashCanLidHit1,
			soundFileTrashCanLidHit2,
			soundFileTrashCanLidHit3,
			soundFileTrashCanLidHit4
	},
	sndGrpTrashRumblingNames = new String[] {
			soundFileTrashRumbling1,
			soundFileTrashRumbling2,
			soundFileTrashRumbling3
	},
	sndGrpPlayerHitNames = new String[] {
			soundFilePlayerTakeHit1,
			soundFilePlayerTakeHit2,
			soundFilePlayerTakeHit3
	},
	sndGrpPlayerHitUnderwaterNames = new String[] {
			soundFilePlayerTakeHitUnderWater1,
			soundFilePlayerTakeHitUnderWater2,
			soundFilePlayerTakeHitUnderWater3
	},
	sndGrpTorpedoLaunchingNames = new String[] {
			soundFileTorpedoLaunching1,
			soundFileTorpedoLaunching2,
			soundFileTorpedoLaunching3
	},
	sndGrpTorpedoExplodingNames = new String[] {
			soundFileTorpedoExploding1,
			soundFileTorpedoExploding2,
			soundFileTorpedoExploding3
	};*/

	public static void load() {

		dispose();

		loaded = false;

		assetManager = new AssetManager();

		musicHandler = new GMTKMusicHandler();

		//assetManager.load("data/Images/DribbleTextures.pack", TextureAtlas.class);
		//assetManager.load("data/Images/DribbleTextures2.pack", TextureAtlas.class);
		assetManager.load("data/Images/GMTK2019Textures.pack", TextureAtlas.class);
		//atlas = new TextureAtlas(Gdx.files.internal("data/Images/DribbleTextures.pack"));

		Preferences preferences = Gdx.app.getPreferences("GMTK2019 Prefs");
		musicVolume = preferences.getFloat("musicVolume", 0.5f);
		soundVolume = preferences.getFloat("soundVolume", 1.0f);
		
		loadMenuSounds();
		loadSoundPrefs();

		FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("data/arial.ttf"));
		FreeTypeFontGenerator.FreeTypeFontParameter parameters = new FreeTypeFontGenerator.FreeTypeFontParameter();

		int size = 22;
		parameters.genMipMaps = true;
		parameters.color = Color.WHITE;
		parameters.size = size;
		parameters.magFilter = Texture.TextureFilter.Linear;
		parameters.minFilter = Texture.TextureFilter.Linear;
		parameters.flip = true;
		generator.scaleForPixelHeight((int) size);

		debugFont = generator.generateFont(parameters);

		debugFont.setUseIntegerPositions(false);

		generator = new FreeTypeFontGenerator(Gdx.files.internal("data/arial.ttf"));
		parameters = new FreeTypeFontGenerator.FreeTypeFontParameter();

		size = 60;
		parameters.genMipMaps = true;
		parameters.color = Color.WHITE;
		parameters.size = size;
		parameters.magFilter = Texture.TextureFilter.Linear;
		parameters.minFilter = Texture.TextureFilter.Linear;
		parameters.flip = true;
		generator.scaleForPixelHeight((int) size);

		buttonFont = generator.generateFont(parameters);

		buttonFont.setUseIntegerPositions(false);

		generator = new FreeTypeFontGenerator(Gdx.files.internal("data/arialItalics.ttf"));
		parameters = new FreeTypeFontGenerator.FreeTypeFontParameter();

		size = 22;
		parameters.genMipMaps = true;
		parameters.color = Color.WHITE;
		parameters.size = size;
		parameters.magFilter = Texture.TextureFilter.Linear;
		parameters.minFilter = Texture.TextureFilter.Linear;
		parameters.flip = true;
		generator.scaleForPixelHeight((int) size);

		debugFontItalics = generator.generateFont(parameters);

		debugFontItalics.setUseIntegerPositions(false);
		
		wojworksTexture = new Texture(Gdx.files.internal("data/Images/spr_wojworks.png"));
		
	}
	
	public static void postload() {
		
		atlas = assetManager.get("data/Images/GMTK2019Textures.pack", TextureAtlas.class);
		//atlas2 = assetManager.get("data/Images/DribbleTextures2.pack", TextureAtlas.class);
		
		loadMusic();
		loadSounds();
		loadTextures();
		loadSprites();
		loadMisc();
		
	}
	
	private static void loadMisc() {
		
		//Nothing here yet in this game.
		
	}
	
	public static void loadMenuSounds() {

		//Nothing here yet in this game.

	}

	public static void loadSound(String filename) {

		assetManager.load(filename, com.badlogic.gdx.audio.Sound.class);

	}

	public static void loadSoundGroup(String[] filenames) {

		//SoundGroup.cpuSaver = true;
		//if (filenames.length > 0)
			//assetManager.load(filenames[0], com.badlogic.gdx.audio.Sound.class);
		for (String filename : filenames)
			assetManager.load(filename, com.badlogic.gdx.audio.Sound.class);

	}

	private static void loadSoundPrefs() {

		//Probably not gonna use in this game.
		/*if (Gdx.app.getType() == Application.ApplicationType.Desktop || Gdx.app.getType() == Application.ApplicationType.HeadlessDesktop) {
			FileHandle file = new FileHandle("SoundVolumes.txt");
			if (file.exists()) {
				JsonValue value = new JsonReader().parse(new String((file).readBytes()));
				vlmBalloonPopping = value.getFloat("vlmBalloonPopping", 0.65f);
				vlmCloudPlatformDissappear = value.getFloat("vlmCloudPlatformDissappear", 1.0f);
				vlmCloudPlatformWeaker = value.getFloat("vlmCloudPlatformWeaker", 1.0f);
				vlmEndBalloonExploding = value.getFloat("vlmEndBalloonExploding", 1.0f);
				vlmEndBalloonPumping = value.getFloat("vlmEndBalloonPumping", 1.0f);
				vlmGoldenGumball = value.getFloat("vlmGoldenGumball", 1.0f);
				vlmPlayerBouncing = value.getFloat("vlmPlayerBouncing", 0.75f);
				vlmPlayerBouncingRubber = value.getFloat("vlmPlayerBouncingRubber", 1.0f);
				vlmPlayerCollectGumball = value.getFloat("vlmPlayerCollectGumball", 0.75f);
				vlmPlayerDestroyingRock = value.getFloat("vlmPlayerDestroyingRock", 0.75f);
				vlmPlayerStickingToGooWall = value.getFloat("vlmPlayerStickingToGooWall", 0.8f);
				vlmPlayerUnstickingFromGooWall = value.getFloat("vlmPlayerUnstickingFromGooWall", 0.8f);
				vlmPlayerWhooshLarge = value.getFloat("vlmPlayerWhooshLarge", 0.5f);
				vlmPlayerWhooshSmall = value.getFloat("vlmPlayerWhooshSmall", 0.5f);
				vlmRobotDeath = value.getFloat("vlmRobotDeath", 1.0f);
				vlmRobotTakeHit1 = value.getFloat("vlmRobotTakeHit1", 1.0f);
				vlmRobotTakeHit2 = value.getFloat("vlmRobotTakeHit2", 1.0f);
				vlmBossCigarBlowingSmoke = value.getFloat("vlmBossCigarBlowingSmoke", 1.0f);
				vlmCannonFireLightingOil = value.getFloat("vlmCannonFireLightingOil", 0.5f);
				vlmCannonGooeySplattering = value.getFloat("vlmCannonGooeySplattering", 1.0f);
				vlmCannonLoadingPlayer = value.getFloat("vlmCannonLoadingPlayer", 1.0f);
				vlmCannonOilSplattering = value.getFloat("vlmCannonOilSplattering", 1.0f);
				vlmCannonShootingFireball = value.getFloat("vlmCannonShootingFireball", 0.6f);
				vlmCannonShootingGooeyball = value.getFloat("vlmCannonShootingGooeyball", 0.25f);
				vlmCannonShootingOilball = value.getFloat("vlmCannonShootingOilball", 0.5f);
				vlmCannonShootingPlayer = value.getFloat("vlmCannonShootingPlayer", 1.0f);
				vlmCushionSpikesDown = value.getFloat("vlmCushionSpikesDown", 1.0f);
				vlmCushionSpikesUp = value.getFloat("vlmCushionSpikesUp", 1.0f);
				vlmMattressBounceLong = value.getFloat("vlmMattressBounceLong", 1.0f);
				vlmMattressBounceShort = value.getFloat("vlmMattressBounceShort", 1.0f);
				vlmPaintDripping = value.getFloat("vlmPaintDripping", 0.30f);
				vlmPlayerEnteringCottonCandy = value.getFloat("vlmPlayerEnteringCottonCandy", 1.0f);
				vlmPlayerGrabbingVine = value.getFloat("vlmPlayerGrabbingVine", 1.0f);
				vlmPlayerHittingBongo = value.getFloat("vlmPlayerHittingBongo", 1.0f);
				vlmPlayerHittingCushion = value.getFloat("vlmPlayerHittingCushion", 1.0f);
				vlmPlayerMovingInCottonCandy = value.getFloat("vlmPlayerMovingInCottonCandy", 1.0f);
				vlmPlayerLeavingCottonCandy = value.getFloat("vlmPlayerLeavingCottonCandy", 1.0f);
				vlmSignTurning = value.getFloat("vlmSignTurning", 1.0f);
				vlmSmallPaintSplash = value.getFloat("vlmSmallPaintSplash", 1.0f);
				vlmSplashIntoWater = value.getFloat("vlmSplashIntoWater", 0.6f);
				vlmSplashOutOfWater = value.getFloat("vlmSplashOutOfWater", 0.6f);
				vlmPlayerSwimming = value.getFloat("vlmPlayerSwimming", 0.6f);
				vlmTeleport1 = value.getFloat("vlmTeleport1", 1.0f);
				vlmTeleport2 = value.getFloat("vlmTeleport2", 1.0f);
				vlmTeleport3 = value.getFloat("vlmTeleport3", 1.0f);
				vlmTrashBagPopping = value.getFloat("vlmTrashBagPopping", 1.0f);
				vlmTrashBursting = value.getFloat("vlmTrashBursting", 1.0f);
				vlmTrashCanLidHit = value.getFloat("vlmTrashCanLidHit", 1.0f);
				vlmTrashRumbling = value.getFloat("vlmTrashRumbling", 1.0f);
				vlmGameShowRight = value.getFloat("vlmGameShowRight", 1.5f);
				vlmGameShowWrong = value.getFloat("vlmGameShowWrong", 1.5f);
				vlmPlayerDeath = value.getFloat("vlmPlayerDeath", 1.0f);
				vlmPlayerDeathUnderwater = value.getFloat("vlmPlayerDeathUnderwater", 1.0f);
				vlmPlayerHit = value.getFloat("vlmPlayerHit", 1.0f);
				vlmPlayerHitUnderwater = value.getFloat("vlmPlayerHitUnderwater", 1.0f);
				vlmTorpedoLaunching = value.getFloat("vlmTorpedoLaunching", 1.0f);
				vlmTorpedoExploding = value.getFloat("vlmTorpedoExploding", 1.0f);
				vlmGameShowRight2 = value.getFloat("vlmGameShowRight2", 2.5f);
				vlmWaterfall = value.getFloat("vlmWaterfall", 0.5f);

				fullSoundDistance = value.getFloat("fullSoundDistance", 8.0f);
				fadeSoundDistance = value.getFloat("fadeSoundDistance", 300.0f);
			}

			file = new FileHandle("DribbleAttributes.txt");
			if (file.exists()) {
				JsonValue value = new JsonReader().parse(new String((file).readBytes()));
				dribbleStickyBallImmunityTimerMax = value.getInt("Dribble sticky ball immunity after unstick", 5);
			}

			file = new FileHandle("BossAttributes.txt");
			if (file.exists()) {
				JsonValue value = new JsonReader().parse(new String((file).readBytes()));
				bossAttackPauseTimerMax = value.getInt("Frames between attacks", 120);
				bossLaserPauseTimerMax = value.getInt("Frames laser stays activated", 180);
				bossHorizontalSpeed = value.getFloat("Horizontal speed", 2.5f);
				bossNormalAmplitude = value.getFloat("Normal amplitude", 16.0f);
				bossSmallAmplitude = value.getFloat("Small amplitude", 8.0f);
			}
		}*/

	}

	public static void loadSounds() {

		//soundBossPoundWhoosh = createSound(soundFileBossPoundWhooshv1, soundManager, 5, false);
		
	}

	public static void disposeSounds() {

		Array<com.badlogic.gdx.audio.Sound> loadedSounds = new Array<com.badlogic.gdx.audio.Sound>();
		assetManager.getAll(com.badlogic.gdx.audio.Sound.class, loadedSounds);
		for (com.badlogic.gdx.audio.Sound sound : loadedSounds)
			assetManager.unload(assetManager.getAssetFileName(sound));

	}

	private static Sound createSound(String fileName, PlaygonSoundManager soundManager, int i, boolean b) {

		if (assetManager.isLoaded(fileName))
			return GMTKGame.createSound(assetManager.get(fileName, com.badlogic.gdx.audio.Sound.class), Gdx.files.internal(fileName), soundManager, i, b);
		else
			return EMPTY_SOUND;

	}
	
	private static void loadMusic() {

		musicMain = new GMTKMusicTemplate(Gdx.files.internal("data/Music/NEFFEX_Destiny_GarageBand.mp3"));
		setMusicVolume(musicVolume);
		
		musicHandler.addMusic(musicMain);
		musicList.add(new Pair<String, MusicTemplate>("Paint Forest", musicMain));
		
	}
	
	public static void setMusicVolume(float musicVolume) {
		
		AssetLoader.musicVolume = musicVolume;
		//musicPaintForest.setVolume(musicVolume);
		
	}
	
	public static void dispose() {}
	
	private static void loadTextures() {
		
		greenTexture = atlas.findRegion("green");
		blackTexture = atlas.findRegion("black");
		whiteTexture = atlas.findRegion("white");
		greenTextBubbleTexture = atlas.findRegion("Textbox");
		blueTextBubbleTexture = atlas.findRegion("TextboxOther");
		buttonTexture = atlas.findRegion("Nine-Slice_Button");
		buttonGrayTexture = atlas.findRegion("Nine-Slice_Button_inactive");
		buttonPressedTexture = atlas.findRegion("Nine-Slice_Button_clicked");
		titleTexture = atlas.findRegion("JusTALK_Title");
		endGoodTexture = atlas.findRegion("JusTALK_Mod");
		endBadTexture = atlas.findRegion("JusTALK_Banned");
		textingUITexture = atlas.findRegion("Top_Layer");
		ellipseTexture = atlas.findRegion("typing_3frames");

	}
	
	private static void loadSprites() {
		
		spriteGreen = new Sprite(greenTexture, 1);
		spriteBlack = new Sprite(blackTexture, 1);
		spriteWhite = new Sprite(whiteTexture, 1);

		spriteGreenTextBubble = new Sprite(greenTextBubbleTexture, 1);
		spriteBlueTextBubble = new Sprite(blueTextBubbleTexture, 1);
		spriteTextingUI = new Sprite(textingUITexture, 1);
		spriteEllipse = new Sprite(ellipseTexture, 3);
		spriteTitle = new Sprite(titleTexture, 1);
		spriteEndGood = new Sprite(endGoodTexture, 1);
		spriteEndBad = new Sprite(endBadTexture, 1);
		
	}
	
}