package com.tencent.mobileqq.widget.share;

import arma;
import armb;

public class ShareActionSheetFactory
{
  public static ShareActionSheet create(ShareActionSheetV2.Param paramParam)
  {
    return new armb(new arma(new ShareActionSheetV2(paramParam)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.widget.share.ShareActionSheetFactory
 * JD-Core Version:    0.7.0.1
 */