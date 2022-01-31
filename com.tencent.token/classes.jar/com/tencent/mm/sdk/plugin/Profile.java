package com.tencent.mm.sdk.plugin;

import android.net.Uri;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;

public class Profile
  extends BaseProfile
{
  public static final Uri CONTENT_URI = Uri.parse("content://com.tencent.mm.sdk.plugin.provider/profile");
  protected static IAutoDBItem.MAutoDBInfo bO = BaseProfile.initAutoDBInfo(Profile.class);
  public static String[] columns = { "username", "bindqq", "bindmobile", "bindemail", "alias", "nickname", "signature", "province", "city", "weibo", "avatar" };
  
  protected IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    return bO;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.plugin.Profile
 * JD-Core Version:    0.7.0.1
 */