package com.tencent.mobileqq.profile.view;

import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.profile.ProfileCardInfo;

public abstract interface ProfileViewUpdate
{
  public static final int a = 0;
  public static final int b = 1;
  public static final String b = "map_key_face";
  public static final int c = 2;
  public static final String c = "map_key_profile_nick_name";
  public static final String d = "map_key_sex_age_area";
  public static final String e = "map_key_level";
  public static final String f = "map_key_level_accelerate";
  public static final String g = "map_key_login_day_layout";
  public static final String h = "map_key_like";
  public static final String i = "map_key_like_image";
  public static final String j = "map_key_voice_intro";
  public static final String k = "map_key_tel";
  public static final String l = "map_key_sign";
  public static final String m = "map_key_play_game";
  public static final String n = "map_key_tag_cloud";
  
  public abstract void a(ProfileActivity.AllInOne paramAllInOne);
  
  public abstract void a(ProfileActivity.AllInOne paramAllInOne, int paramInt, String paramString);
  
  public abstract void a(ProfileCardInfo paramProfileCardInfo, long paramLong);
  
  public abstract void c(ProfileCardInfo paramProfileCardInfo);
  
  public abstract void d(ProfileCardInfo paramProfileCardInfo);
  
  public abstract void e(ProfileCardInfo paramProfileCardInfo);
  
  public abstract void f(ProfileCardInfo paramProfileCardInfo);
  
  public abstract void g(ProfileCardInfo paramProfileCardInfo);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.profile.view.ProfileViewUpdate
 * JD-Core Version:    0.7.0.1
 */