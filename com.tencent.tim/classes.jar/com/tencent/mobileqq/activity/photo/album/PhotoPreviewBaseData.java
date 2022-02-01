package com.tencent.mobileqq.activity.photo.album;

import java.util.ArrayList;
import java.util.HashMap;

public class PhotoPreviewBaseData
{
  public static final String BACK_BTN_TEXT = "back_btn_text";
  public String backBtnText;
  public int cameraType;
  public boolean canUseURL = false;
  public String customSendBtnText = null;
  public HashMap<String, String> editPathMap = new HashMap();
  public int firstSelectedPostion;
  public String from;
  public boolean isSingleMode = false;
  public long lastTimeShowToast;
  public ArrayList<String> paths;
  public boolean showAlbum = false;
  public boolean showBar = true;
  public int titleBarHeight;
  public int totalPicCount = 0;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.album.PhotoPreviewBaseData
 * JD-Core Version:    0.7.0.1
 */