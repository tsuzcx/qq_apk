package com.tencent.qqmail.utilities.imageextention;

import com.tencent.qqmail.attachment.model.AttachType;

public class ImageResourceUtil
{
  private static final int[] DEFAULT_AUDIO_AVATAR = { 2130840415, 2130840416, 2130840417, 2130840414 };
  private static final int[] DEFAULT_COMPRESS_AVATAR = { 2130840419, 2130840420, 2130840421, 2130840418 };
  private static final int[] DEFAULT_EML_AVATAR = { 2130840424, 2130840425, 2130840426, 2130840423 };
  private static final int[] DEFAULT_EXCEL_AVATAR = { 2130840428, 2130840429, 2130840430, 2130840427 };
  private static final int[] DEFAULT_FLASH_AVATAR = { 2130840432, 2130840433, 2130840434, 2130840431 };
  private static final int[] DEFAULT_FOLDER_AVATAR = { 2130840436, 2130840437, 2130840438, 2130840435 };
  private static final int[] DEFAULT_HTML_AVATAR = { 2130840440, 2130840441, 2130840442, 2130840439 };
  private static final int[] DEFAULT_ICS_AVATAR = { 2130840444, 2130840445, 2130840446, 2130840443 };
  private static final int[] DEFAULT_IMAGE_AVATAR = { 2130840448, 2130840449, 2130840450, 2130840447 };
  private static final int[] DEFAULT_KEYNOTE_AVATAR = { 2130840452, 2130840453, 2130840454, 2130840451 };
  private static final int[] DEFAULT_NUMBERS_AVATAR = { 2130840456, 2130840457, 2130840458, 2130840455 };
  private static final int[] DEFAULT_OTHERS_AVATAR = { 2130840460, 2130840461, 2130840462, 2130840459 };
  private static final int[] DEFAULT_PAGES_AVATAR = { 2130840464, 2130840465, 2130840466, 2130840463 };
  private static final int[] DEFAULT_PDF_AVATAR = { 2130840468, 2130840469, 2130840470, 2130840467 };
  private static final int[] DEFAULT_PPT_AVATAR = { 2130840472, 2130840473, 2130840474, 2130840471 };
  private static final int[] DEFAULT_PSD_AVATAR = { 2130840476, 2130840477, 2130840478, 2130840475 };
  private static final int[] DEFAULT_TXT_AVATAR = { 2130840480, 2130840481, 2130840482, 2130840479 };
  private static final int[] DEFAULT_VIDEO_AVATAR = { 2130840484, 2130840485, 2130840486, 2130840483 };
  private static final int[] DEFAULT_WORD_AVATAR = { 2130840488, 2130840489, 2130840490, 2130840487 };
  public static int IMAGE_SIZE_124;
  public static int IMAGE_SIZE_32 = 0;
  public static int IMAGE_SIZE_58 = 1;
  public static int IMAGE_SIZE_76 = 2;
  
  static
  {
    IMAGE_SIZE_124 = 3;
  }
  
  public static int getImageResource(String paramString, int paramInt)
  {
    int i;
    if (paramInt >= 0)
    {
      i = paramInt;
      if (paramInt <= 3) {}
    }
    else
    {
      i = Math.abs(paramInt) % 4;
    }
    if (paramString == null) {
      return DEFAULT_OTHERS_AVATAR[i];
    }
    if (paramString.equalsIgnoreCase(AttachType.AUDIO.name())) {
      return DEFAULT_AUDIO_AVATAR[i];
    }
    if (paramString.equalsIgnoreCase(AttachType.COMPRESS.name())) {
      return DEFAULT_COMPRESS_AVATAR[i];
    }
    if (paramString.equalsIgnoreCase(AttachType.EML.name())) {
      return DEFAULT_EML_AVATAR[i];
    }
    if (paramString.equalsIgnoreCase(AttachType.EXCEL.name())) {
      return DEFAULT_EXCEL_AVATAR[i];
    }
    if (paramString.equalsIgnoreCase(AttachType.FLASH.name())) {
      return DEFAULT_FLASH_AVATAR[i];
    }
    if (paramString.equalsIgnoreCase("folder")) {
      return DEFAULT_FOLDER_AVATAR[i];
    }
    if (paramString.equalsIgnoreCase(AttachType.HTML.name())) {
      return DEFAULT_HTML_AVATAR[i];
    }
    if (paramString.equalsIgnoreCase(AttachType.ICS.name())) {
      return DEFAULT_ICS_AVATAR[i];
    }
    if (paramString.equalsIgnoreCase(AttachType.IMAGE.name())) {
      return DEFAULT_IMAGE_AVATAR[i];
    }
    if (paramString.equalsIgnoreCase(AttachType.KEYNOTE.name())) {
      return DEFAULT_KEYNOTE_AVATAR[i];
    }
    if (paramString.equalsIgnoreCase(AttachType.NUMBERS.name())) {
      return DEFAULT_NUMBERS_AVATAR[i];
    }
    if (paramString.equalsIgnoreCase(AttachType.OTHERS.name())) {
      return DEFAULT_OTHERS_AVATAR[i];
    }
    if (paramString.equalsIgnoreCase(AttachType.PAGES.name())) {
      return DEFAULT_PAGES_AVATAR[i];
    }
    if (paramString.equalsIgnoreCase(AttachType.PDF.name())) {
      return DEFAULT_PDF_AVATAR[i];
    }
    if (paramString.equalsIgnoreCase(AttachType.PPT.name())) {
      return DEFAULT_PPT_AVATAR[i];
    }
    if (paramString.equalsIgnoreCase(AttachType.PSD.name())) {
      return DEFAULT_PSD_AVATAR[i];
    }
    if (paramString.equalsIgnoreCase(AttachType.TXT.name())) {
      return DEFAULT_TXT_AVATAR[i];
    }
    if (paramString.equalsIgnoreCase(AttachType.VIDEO.name())) {
      return DEFAULT_VIDEO_AVATAR[i];
    }
    if (paramString.equalsIgnoreCase(AttachType.WORD.name())) {
      return DEFAULT_WORD_AVATAR[i];
    }
    return DEFAULT_OTHERS_AVATAR[i];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.imageextention.ImageResourceUtil
 * JD-Core Version:    0.7.0.1
 */