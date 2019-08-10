package com.mwojnar.GameEngine;

import com.badlogic.gdx.graphics.Color;
import com.mwojnar.Assets.AssetLoader;
import com.playgon.GameEngine.Sprite;
import com.playgon.GameWorld.GameRenderer;

public class GMTKText {
	
	public enum Align {
		
		LEFT, CENTER, RIGHT
		
	}
	
	public GMTKText() {}
	
//	public void draw(GameRenderer renderer, float x, float y, String text) {
//		
//		StringBuilder string = new StringBuilder(text);
//		for (int i = 0; i < string.length(); i++) {
//			
//			char character = string.charAt(i);
//			if (!((character >= 65 && character < 65 + 26) || (character >= 97 && character < 97 + 26) || (character == 32) || (character >= 48 && character < 48 + 10) || (character == 45) || (character == 63))) {
//				
//				string.deleteCharAt(i);
//				i--;
//				
//			}
//			
//		}
//		text = string.toString();
//		for (int i = 0; i < text.length(); i++) {
//			
//			char character = text.charAt(i);
//			boolean isNumber = false;
//			boolean isSpace = false;
//			if (character >= 65 && character < 65 + 26) {
//				
//				character -= 65;
//				
//			}
//			if (character >= 97 && character < 97 + 26) {
//				
//				character -= 97;
//				
//			}
//			if (character == 45) {
//				
//				character = 27;
//				
//			}
//			if (character == 63) {
//				
//				character = 26;
//				
//			}
//			if (character == 32) {
//				
//				isSpace = true;
//				
//			}
//			if (character >= 48 && character < 48 + 10) {
//				
//				if (character == 48) {
//					
//					character = 9;
//					
//				} else {
//					
//					character -= 49;
//					
//				}
//				isNumber = true;
//				
//			}
//			
//			if (!isSpace) {
//				
//				if (isNumber) {
//					
//					numberText.draw(x + 15.0f * i, y, character, 1.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f, renderer);
//					
//				} else {
//					
//					letterText.draw(x + 15.0f * i, y, character, 1.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f, renderer);
//					
//				}
//				
//			}
//			
//		}
//		
//	}
//	
//	public void drawAbsolute(GameRenderer renderer, float x, float y, String text) {
//		
//		StringBuilder string = new StringBuilder(text);
//		for (int i = 0; i < string.length(); i++) {
//			
//			char character = string.charAt(i);
//			if (!((character >= 65 && character < 65 + 26) || (character >= 97 && character < 97 + 26) || (character == 32) || (character >= 48 && character < 48 + 10) || (character == 45) || (character == 63))) {
//				
//				string.deleteCharAt(i);
//				i--;
//				
//			}
//			
//		}
//		text = string.toString();
//		for (int i = 0; i < text.length(); i++) {
//			
//			char character = text.charAt(i);
//			boolean isNumber = false;
//			boolean isSpace = false;
//			if (character >= 65 && character < 65 + 26) {
//				
//				character -= 65;
//				
//			}
//			if (character >= 97 && character < 97 + 26) {
//				
//				character -= 97;
//				
//			}
//			if (character == 45) {
//				
//				character = 27;
//				
//			}
//			if (character == 63) {
//				
//				character = 26;
//				
//			}
//			if (character == 32) {
//				
//				isSpace = true;
//				
//			}
//			if (character >= 48 && character < 48 + 10) {
//				
//				if (character == 48) {
//					
//					character = 9;
//					
//				} else {
//					
//					character -= 49;
//					
//				}
//				isNumber = true;
//				
//			}
//			
//			if (!isSpace) {
//				
//				if (isNumber) {
//					
//					numberText.drawAbsolute(x + 15.0f * i, y, character, 1.0f, 1.0f, 0.0f, 0.0f, 0.0f, renderer);
//					
//				} else {
//					
//					letterText.drawAbsolute(x + 15.0f * i, y, character, 1.0f, 1.0f, 0.0f, 0.0f, 0.0f, renderer);
//					
//				}
//				
//			}
//			
//		}
//		
//	}
//	
//	public void drawAbsolute(GameRenderer renderer, float x, float y, String text, float scaleX, float scaleY, float rotation, Align alignment, Align rotationCenter) {
//		
//		StringBuilder string = new StringBuilder(text);
//		for (int i = 0; i < string.length(); i++) {
//			
//			char character = string.charAt(i);
//			if (!((character >= 65 && character < 65 + 26) || (character >= 97 && character < 97 + 26) || (character == 32) || (character >= 48 && character < 48 + 10) || (character == 45) || (character == 63))) {
//				
//				string.deleteCharAt(i);
//				i--;
//				
//			}
//			
//		}
//		text = string.toString();
//		if (alignment == Align.CENTER) {
//			
//			x -= text.length() * 15.0f / 2.0f;
//			
//		} else if (alignment == Align.RIGHT) {
//			
//			x -= text.length() * 15.0f;
//			
//		}
//		float centerX = 0.0f, centerY = 20.0f / 2.0f;
//		if (rotationCenter == Align.CENTER) {
//			
//			centerX = text.length() * 15.0f / 2.0f;
//			
//		} else if (rotationCenter == Align.RIGHT) {
//			
//			centerX = text.length() * 15.0f;
//			
//		}
//		for (int i = 0; i < text.length(); i++) {
//			
//			char character = text.charAt(i);
//			boolean isNumber = false;
//			boolean isSpace = false;
//			if (character >= 65 && character < 65 + 26) {
//				
//				character -= 65;
//				
//			}
//			if (character >= 97 && character < 97 + 26) {
//				
//				character -= 97;
//				
//			}
//			if (character == 45) {
//				
//				character = 27;
//				
//			}
//			if (character == 63) {
//				
//				character = 26;
//				
//			}
//			if (character == 32) {
//				
//				isSpace = true;
//				
//			}
//			if (character >= 48 && character < 48 + 10) {
//				
//				if (character == 48) {
//					
//					character = 9;
//					
//				} else {
//					
//					character -= 49;
//					
//				}
//				isNumber = true;
//				
//			}
//			
//			if (!isSpace) {
//				
//				if (isNumber) {
//					
//					numberText.drawAbsolute(x + 15.0f * i, y, character, scaleX, scaleY, rotation, centerX - 15.0f * i, centerY, renderer);
//					
//				} else {
//					
//					letterText.drawAbsolute(x + 15.0f * i, y, character, scaleX, scaleY, rotation, centerX - 15.0f * i, centerY, renderer);
//					
//				}
//				
//			}
//			
//		}
//		
//	}
//	
//	public void drawAbsolute(GameRenderer renderer, float x, float y, String text, float scaleX, float scaleY, float rotation, Align alignment, Align rotationCenter, int maxCharWidth, float alpha) {
//		
//		StringBuilder string = new StringBuilder(text);
//		for (int i = 0; i < string.length(); i++) {
//			
//			char character = string.charAt(i);
//			if (!((character >= 65 && character < 65 + 26) || (character >= 97 && character < 97 + 26) || (character == 32) || (character >= 48 && character < 48 + 10) || (character == 45) || (character == 63))) {
//				
//				string.deleteCharAt(i);
//				i--;
//				
//			}
//			
//		}
//		text = string.toString();
//		String[] textLines = null;
//		if (maxCharWidth > 0 && text.length() > maxCharWidth) {
//			
//			textLines = splitIntolines(text, maxCharWidth);
//			
//		} else {
//			
//			textLines = new String[1];
//			textLines[0] = text;
//			
//		}
//		for (int j = 0; j < textLines.length; j++) {
//			
//			for (int i = 0; i < textLines[j].length(); i++) {
//				
//				char character = textLines[j].charAt(i);
//				boolean isNumber = false;
//				boolean isSpace = false;
//				if (character >= 65 && character < 65 + 26) {
//					
//					character -= 65;
//					
//				}
//				if (character >= 97 && character < 97 + 26) {
//					
//					character -= 97;
//					
//				}
//				if (character == 45) {
//					
//					character = 27;
//					
//				}
//				if (character == 63) {
//					
//					character = 26;
//					
//				}
//				if (character == 32) {
//					
//					isSpace = true;
//					
//				}
//				if (character >= 48 && character < 48 + 10) {
//					
//					if (character == 48) {
//						
//						character = 9;
//						
//					} else {
//						
//						character -= 49;
//						
//					}
//					isNumber = true;
//					
//				}
//				
//				if (!isSpace) {
//					
//					float trueX = x;
//					if (alignment == Align.CENTER) {
//						
//						trueX -= textLines[j].length() * 15.0f / 2.0f;
//						
//					} else if (alignment == Align.RIGHT) {
//						
//						trueX -= textLines[j].length() * 15.0f;
//						
//					}
//					float centerX = 0.0f, centerY = 20.0f / 2.0f;
//					if (rotationCenter == Align.CENTER) {
//						
//						centerX = textLines[j].length() * 15.0f / 2.0f;
//						
//					} else if (rotationCenter == Align.RIGHT) {
//						
//						centerX = textLines[j].length() * 15.0f;
//						
//					}
//					Color prevColor = renderer.getBatcher().getColor();
//					renderer.getBatcher().setColor(prevColor.r, prevColor.g, prevColor.b, alpha);
//					if (isNumber) {
//						
//						numberText.drawAbsolute(trueX + 15.0f * i, y + scaleY * (letterText.getHeight() + 2.0f) * j - (scaleY * (letterText.getHeight() + 2.0f) * textLines.length) / 2.0f, character, scaleX, scaleY, rotation, centerX - 15.0f * i, centerY, renderer);
//						
//					} else {
//						
//						letterText.drawAbsolute(trueX + 15.0f * i, y + scaleY * (letterText.getHeight() + 2.0f) * j - (scaleY * (letterText.getHeight() + 2.0f) * textLines.length) / 2.0f, character, scaleX, scaleY, rotation, centerX - 15.0f * i, centerY, renderer);
//						
//					}
//					renderer.getBatcher().setColor(prevColor);
//					
//				}
//				
//			}
//			
//		}
//		
//	}
	
	public void draw(GameRenderer renderer, float x, float y, String text, float scaleX, float scaleY, float rotation, Align alignment, Align rotationCenter, int maxCharWidth, Color color) {
		
		StringBuilder string = new StringBuilder(text);
		for (int i = 0; i < string.length(); i++) {
			
			char character = string.charAt(i);
			if (!((character >= 65 && character < 65 + 26) || (character >= 97 && character < 97 + 26) || (character == 32) || (character >= 48 && character < 48 + 10) || (character == 45) || (character == 63))) {
				
				string.deleteCharAt(i);
				i--;
				
			}
			
		}
		text = string.toString();
		String[] textLines = null;
		if (maxCharWidth > 0 && text.length() > maxCharWidth) {
			
			textLines = splitIntolines(text, maxCharWidth);
			
		} else {
			
			textLines = new String[1];
			textLines[0] = text;
			
		}
		for (int j = 0; j < textLines.length; j++) {
			
			for (int i = 0; i < textLines[j].length(); i++) {
				
				char character = textLines[j].charAt(i);
				boolean isNumber = false;
				boolean isSpace = false;
				if (character >= 65 && character < 65 + 26) {
					
					character -= 65;
					
				}
				if (character >= 97 && character < 97 + 26) {
					
					character -= 97;
					
				}
				if (character == 45) {
					
					character = 27;
					
				}
				if (character == 63) {
					
					character = 26;
					
				}
				if (character == 32) {
					
					isSpace = true;
					
				}
				if (character >= 48 && character < 48 + 10) {
					
					if (character == 48) {
						
						character = 9;
						
					} else {
						
						character -= 49;
						
					}
					isNumber = true;
					
				}
				
				if (!isSpace) {
					
					float trueX = x;
					if (alignment == Align.CENTER) {
						
						trueX -= textLines[j].length() * 15.0f / 2.0f;
						
					} else if (alignment == Align.RIGHT) {
						
						trueX -= textLines[j].length() * 15.0f;
						
					}
					float centerX = 0.0f, centerY = 20.0f / 2.0f;
					if (rotationCenter == Align.CENTER) {
						
						centerX = textLines[j].length() * 15.0f / 2.0f;
						
					} else if (rotationCenter == Align.RIGHT) {
						
						centerX = textLines[j].length() * 15.0f;
						
					}
					Color prevColor = renderer.getBatcher().getColor();
					renderer.getBatcher().setColor(color);
					if (isNumber) {
						
						//AssetLoader.spriteTextNumbers.draw(trueX + 15.0f * i, y + scaleY * (AssetLoader.spriteTextLetters.getHeight() + 2.0f) * j - (scaleY * (AssetLoader.spriteTextLetters.getHeight() + 2.0f) * textLines.length) / 2.0f, character, scaleX, scaleY, rotation, centerX - 15.0f * i, centerY, renderer);
						
					} else {
						
						//AssetLoader.spriteTextLetters.draw(trueX + 15.0f * i, y + scaleY * (AssetLoader.spriteTextLetters.getHeight() + 2.0f) * j - (scaleY * (AssetLoader.spriteTextLetters.getHeight() + 2.0f) * textLines.length) / 2.0f, character, scaleX, scaleY, rotation, centerX - 15.0f * i, centerY, renderer);
						
					}
					renderer.getBatcher().setColor(prevColor);
					
				}
				
			}
			
		}
		
	}
	
	public void drawAbsolute(GameRenderer renderer, float x, float y, String text, float scaleX, float scaleY, float rotation, Align alignment, Align rotationCenter, int maxCharWidth, Color color) {
		
		StringBuilder string = new StringBuilder(text);
		for (int i = 0; i < string.length(); i++) {
			
			char character = string.charAt(i);
			if (!((character >= 65 && character < 65 + 26) || (character >= 97 && character < 97 + 26) || (character == 32) || (character >= 48 && character < 48 + 10) || (character == 45) || (character == 63))) {
				
				string.deleteCharAt(i);
				i--;
				
			}
			
		}
		text = string.toString();
		String[] textLines = null;
		if (maxCharWidth > 0 && text.length() > maxCharWidth) {
			
			textLines = splitIntolines(text, maxCharWidth);
			
		} else {
			
			textLines = new String[1];
			textLines[0] = text;
			
		}
		for (int j = 0; j < textLines.length; j++) {
			
			for (int i = 0; i < textLines[j].length(); i++) {
				
				char character = textLines[j].charAt(i);
				boolean isNumber = false;
				boolean isSpace = false;
				if (character >= 65 && character < 65 + 26) {
					
					character -= 65;
					
				}
				if (character >= 97 && character < 97 + 26) {
					
					character -= 97;
					
				}
				if (character == 45) {
					
					character = 27;
					
				}
				if (character == 63) {
					
					character = 26;
					
				}
				if (character == 32) {
					
					isSpace = true;
					
				}
				if (character >= 48 && character < 48 + 10) {
					
					if (character == 48) {
						
						character = 9;
						
					} else {
						
						character -= 49;
						
					}
					isNumber = true;
					
				}
				
				if (!isSpace) {
					
					float trueX = x;
					if (alignment == Align.CENTER) {
						
						trueX -= textLines[j].length() * 15.0f / 2.0f;
						
					} else if (alignment == Align.RIGHT) {
						
						trueX -= textLines[j].length() * 15.0f;
						
					}
					float centerX = 0.0f, centerY = 20.0f / 2.0f;
					if (rotationCenter == Align.CENTER) {
						
						centerX = textLines[j].length() * 15.0f / 2.0f;
						
					} else if (rotationCenter == Align.RIGHT) {
						
						centerX = textLines[j].length() * 15.0f;
						
					}
					Color prevColor = renderer.getBatcher().getColor();
					renderer.getBatcher().setColor(color);
					if (isNumber) {
						
						//AssetLoader.spriteTextNumbers.drawAbsolute(trueX + 15.0f * i, y + scaleY * (AssetLoader.spriteTextLetters.getHeight() + 2.0f) * j - (scaleY * (AssetLoader.spriteTextLetters.getHeight() + 2.0f) * textLines.length) / 2.0f, character, scaleX, scaleY, rotation, centerX - 15.0f * i, centerY, renderer);
						
					} else {
						
						//AssetLoader.spriteTextLetters.drawAbsolute(trueX + 15.0f * i, y + scaleY * (AssetLoader.spriteTextLetters.getHeight() + 2.0f) * j - (scaleY * (AssetLoader.spriteTextLetters.getHeight() + 2.0f) * textLines.length) / 2.0f, character, scaleX, scaleY, rotation, centerX - 15.0f * i, centerY, renderer);
						
					}
					renderer.getBatcher().setColor(prevColor);
					
				}
				
			}
			
		}
		
	}

	private String[] splitIntolines(String text, int maxCharWidth) {
		
		int charCounter = 0;
		String[] splitWords = text.split(" ");
		String endText = "";
		for (int i = 0; i < splitWords.length; i++) {
			
			if (charCounter == 0) {
				
				endText += splitWords[i];
				charCounter += splitWords[i].length();
				
			} else {
				
				if (charCounter + splitWords[i].length() + 1 <= maxCharWidth) {
					
					endText += " ";
					endText += splitWords[i];
					charCounter += splitWords[i].length() + 1;
					
				} else {
					
					endText += "\n";
					endText += splitWords[i];
					charCounter = splitWords[i].length();
					
				}
				
			}
			
		}
		
		return endText.split("\n");
		
	}
	
}