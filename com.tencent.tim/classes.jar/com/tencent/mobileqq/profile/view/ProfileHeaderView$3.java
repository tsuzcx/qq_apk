package com.tencent.mobileqq.profile.view;

import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;

class ProfileHeaderView$3
  implements Runnable
{
  ProfileHeaderView$3(ProfileHeaderView paramProfileHeaderView, int paramInt, ProfileActivity.AllInOne paramAllInOne, String paramString) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore_3
    //   5: aconst_null
    //   6: astore 5
    //   8: aload_0
    //   9: getfield 18	com/tencent/mobileqq/profile/view/ProfileHeaderView$3:this$0	Lcom/tencent/mobileqq/profile/view/ProfileHeaderView;
    //   12: invokevirtual 39	com/tencent/mobileqq/profile/view/ProfileHeaderView:getResources	()Landroid/content/res/Resources;
    //   15: ldc 40
    //   17: invokevirtual 46	android/content/res/Resources:getDimensionPixelSize	(I)I
    //   20: istore_1
    //   21: aload_0
    //   22: getfield 18	com/tencent/mobileqq/profile/view/ProfileHeaderView$3:this$0	Lcom/tencent/mobileqq/profile/view/ProfileHeaderView;
    //   25: getfield 50	com/tencent/mobileqq/profile/view/ProfileHeaderView:mt	Ljava/util/HashMap;
    //   28: ldc 52
    //   30: invokevirtual 58	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   33: checkcast 60	com/tencent/mobileqq/vas/avatar/AvatarLayout
    //   36: astore_2
    //   37: aload_2
    //   38: ifnonnull +237 -> 275
    //   41: aconst_null
    //   42: astore_2
    //   43: aload_2
    //   44: checkcast 62	android/widget/ImageView
    //   47: checkcast 62	android/widget/ImageView
    //   50: astore_2
    //   51: iconst_3
    //   52: aload_0
    //   53: getfield 20	com/tencent/mobileqq/profile/view/ProfileHeaderView$3:val$type	I
    //   56: if_icmpeq +19 -> 75
    //   59: aload_2
    //   60: instanceof 64
    //   63: ifeq +12 -> 75
    //   66: aload_2
    //   67: checkcast 64	com/tencent/mobileqq/avatar/dynamicavatar/DynamicAvatarView
    //   70: ldc 66
    //   72: putfield 69	com/tencent/mobileqq/avatar/dynamicavatar/DynamicAvatarView:text	Ljava/lang/String;
    //   75: aload_0
    //   76: getfield 20	com/tencent/mobileqq/profile/view/ProfileHeaderView$3:val$type	I
    //   79: ifne +231 -> 310
    //   82: aload 5
    //   84: astore_2
    //   85: aload_0
    //   86: getfield 22	com/tencent/mobileqq/profile/view/ProfileHeaderView$3:f	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   89: getfield 74	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:pa	I
    //   92: ifne +100 -> 192
    //   95: aload 5
    //   97: astore_2
    //   98: invokestatic 80	aqep:aBY	()Z
    //   101: ifeq +91 -> 192
    //   104: invokestatic 84	aqep:BS	()Ljava/lang/String;
    //   107: astore_2
    //   108: new 86	java/io/File
    //   111: dup
    //   112: aload_2
    //   113: invokespecial 89	java/io/File:<init>	(Ljava/lang/String;)V
    //   116: astore 5
    //   118: new 91	android/graphics/BitmapFactory$Options
    //   121: dup
    //   122: invokespecial 92	android/graphics/BitmapFactory$Options:<init>	()V
    //   125: astore 4
    //   127: new 94	java/io/FileInputStream
    //   130: dup
    //   131: aload 5
    //   133: invokespecial 97	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   136: astore 5
    //   138: aload 4
    //   140: aload 5
    //   142: iload_1
    //   143: iload_1
    //   144: invokestatic 103	aqhu:getOptRatio	(Ljava/io/InputStream;II)D
    //   147: d2i
    //   148: putfield 106	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   151: aload 5
    //   153: invokevirtual 111	java/io/InputStream:close	()V
    //   156: aload_2
    //   157: aload 4
    //   159: invokestatic 117	aqcu:decodeFile	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   162: astore_2
    //   163: aload_2
    //   164: astore_3
    //   165: aload_2
    //   166: ifnull +24 -> 190
    //   169: aload_0
    //   170: getfield 18	com/tencent/mobileqq/profile/view/ProfileHeaderView$3:this$0	Lcom/tencent/mobileqq/profile/view/ProfileHeaderView;
    //   173: getfield 121	com/tencent/mobileqq/profile/view/ProfileHeaderView:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   176: astore_3
    //   177: aload_2
    //   178: aload_2
    //   179: invokevirtual 127	android/graphics/Bitmap:getWidth	()I
    //   182: aload_2
    //   183: invokevirtual 130	android/graphics/Bitmap:getHeight	()I
    //   186: invokestatic 136	com/tencent/mobileqq/app/QQAppInterface:getCircleFaceBitmap	(Landroid/graphics/Bitmap;II)Landroid/graphics/Bitmap;
    //   189: astore_3
    //   190: aload_3
    //   191: astore_2
    //   192: aload_2
    //   193: astore_3
    //   194: aload_0
    //   195: getfield 22	com/tencent/mobileqq/profile/view/ProfileHeaderView$3:f	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   198: getfield 74	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:pa	I
    //   201: bipush 80
    //   203: if_icmpne +23 -> 226
    //   206: aload_0
    //   207: getfield 18	com/tencent/mobileqq/profile/view/ProfileHeaderView$3:this$0	Lcom/tencent/mobileqq/profile/view/ProfileHeaderView;
    //   210: getfield 140	com/tencent/mobileqq/profile/view/ProfileHeaderView:mActivity	Lcom/tencent/mobileqq/app/BaseActivity;
    //   213: getfield 143	com/tencent/mobileqq/app/BaseActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   216: aload_0
    //   217: getfield 24	com/tencent/mobileqq/profile/view/ProfileHeaderView$3:val$key	Ljava/lang/String;
    //   220: bipush 16
    //   222: invokevirtual 147	com/tencent/mobileqq/app/QQAppInterface:h	(Ljava/lang/String;I)Landroid/graphics/Bitmap;
    //   225: astore_3
    //   226: aload_3
    //   227: astore_2
    //   228: aload_3
    //   229: ifnonnull +22 -> 251
    //   232: aload_0
    //   233: getfield 18	com/tencent/mobileqq/profile/view/ProfileHeaderView$3:this$0	Lcom/tencent/mobileqq/profile/view/ProfileHeaderView;
    //   236: getfield 140	com/tencent/mobileqq/profile/view/ProfileHeaderView:mActivity	Lcom/tencent/mobileqq/app/BaseActivity;
    //   239: getfield 143	com/tencent/mobileqq/app/BaseActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   242: aload_0
    //   243: getfield 24	com/tencent/mobileqq/profile/view/ProfileHeaderView$3:val$key	Ljava/lang/String;
    //   246: iconst_1
    //   247: invokevirtual 151	com/tencent/mobileqq/app/QQAppInterface:getFaceBitmap	(Ljava/lang/String;Z)Landroid/graphics/Bitmap;
    //   250: astore_2
    //   251: aload_2
    //   252: ifnull +22 -> 274
    //   255: aload_0
    //   256: getfield 18	com/tencent/mobileqq/profile/view/ProfileHeaderView$3:this$0	Lcom/tencent/mobileqq/profile/view/ProfileHeaderView;
    //   259: getfield 140	com/tencent/mobileqq/profile/view/ProfileHeaderView:mActivity	Lcom/tencent/mobileqq/app/BaseActivity;
    //   262: new 153	com/tencent/mobileqq/profile/view/ProfileHeaderView$3$1
    //   265: dup
    //   266: aload_0
    //   267: aload_2
    //   268: invokespecial 156	com/tencent/mobileqq/profile/view/ProfileHeaderView$3$1:<init>	(Lcom/tencent/mobileqq/profile/view/ProfileHeaderView$3;Landroid/graphics/Bitmap;)V
    //   271: invokevirtual 160	com/tencent/mobileqq/app/BaseActivity:runOnUiThread	(Ljava/lang/Runnable;)V
    //   274: return
    //   275: aload_2
    //   276: iconst_0
    //   277: invokevirtual 164	com/tencent/mobileqq/vas/avatar/AvatarLayout:Q	(I)Landroid/view/View;
    //   280: astore_2
    //   281: goto -238 -> 43
    //   284: astore 4
    //   286: aload_3
    //   287: astore_2
    //   288: invokestatic 169	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   291: ifeq -99 -> 192
    //   294: ldc 171
    //   296: iconst_2
    //   297: aload 4
    //   299: invokevirtual 174	java/lang/Exception:toString	()Ljava/lang/String;
    //   302: invokestatic 178	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   305: aload_3
    //   306: astore_2
    //   307: goto -115 -> 192
    //   310: iconst_1
    //   311: aload_0
    //   312: getfield 20	com/tencent/mobileqq/profile/view/ProfileHeaderView$3:val$type	I
    //   315: if_icmpne +26 -> 341
    //   318: aload_0
    //   319: getfield 18	com/tencent/mobileqq/profile/view/ProfileHeaderView$3:this$0	Lcom/tencent/mobileqq/profile/view/ProfileHeaderView;
    //   322: getfield 121	com/tencent/mobileqq/profile/view/ProfileHeaderView:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   325: bipush 11
    //   327: aload_0
    //   328: getfield 24	com/tencent/mobileqq/profile/view/ProfileHeaderView$3:val$key	Ljava/lang/String;
    //   331: iconst_1
    //   332: iconst_1
    //   333: iconst_0
    //   334: invokevirtual 181	com/tencent/mobileqq/app/QQAppInterface:getFaceBitmap	(ILjava/lang/String;BZI)Landroid/graphics/Bitmap;
    //   337: astore_2
    //   338: goto -87 -> 251
    //   341: iconst_3
    //   342: aload_0
    //   343: getfield 20	com/tencent/mobileqq/profile/view/ProfileHeaderView$3:val$type	I
    //   346: if_icmpne +105 -> 451
    //   349: aload_2
    //   350: instanceof 64
    //   353: ifeq +57 -> 410
    //   356: aload_2
    //   357: checkcast 64	com/tencent/mobileqq/avatar/dynamicavatar/DynamicAvatarView
    //   360: astore_2
    //   361: aload_2
    //   362: aload_0
    //   363: getfield 18	com/tencent/mobileqq/profile/view/ProfileHeaderView$3:this$0	Lcom/tencent/mobileqq/profile/view/ProfileHeaderView;
    //   366: getfield 185	com/tencent/mobileqq/profile/view/ProfileHeaderView:a	Lalcn;
    //   369: getfield 190	alcn:e	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   372: getfield 193	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:contactName	Ljava/lang/String;
    //   375: invokestatic 199	aqgv:ps	(Ljava/lang/String;)Ljava/lang/String;
    //   378: putfield 69	com/tencent/mobileqq/avatar/dynamicavatar/DynamicAvatarView:text	Ljava/lang/String;
    //   381: aload_2
    //   382: getfield 69	com/tencent/mobileqq/avatar/dynamicavatar/DynamicAvatarView:text	Ljava/lang/String;
    //   385: invokestatic 203	aqgv:mH	(Ljava/lang/String;)Z
    //   388: ifeq +41 -> 429
    //   391: aload_2
    //   392: aload_0
    //   393: getfield 18	com/tencent/mobileqq/profile/view/ProfileHeaderView$3:this$0	Lcom/tencent/mobileqq/profile/view/ProfileHeaderView;
    //   396: invokevirtual 207	com/tencent/mobileqq/profile/view/ProfileHeaderView:getContext	()Landroid/content/Context;
    //   399: invokevirtual 210	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   402: ldc 211
    //   404: invokevirtual 46	android/content/res/Resources:getDimensionPixelSize	(I)I
    //   407: invokevirtual 215	com/tencent/mobileqq/avatar/dynamicavatar/DynamicAvatarView:setTextSize	(I)V
    //   410: aload_0
    //   411: getfield 18	com/tencent/mobileqq/profile/view/ProfileHeaderView$3:this$0	Lcom/tencent/mobileqq/profile/view/ProfileHeaderView;
    //   414: invokevirtual 207	com/tencent/mobileqq/profile/view/ProfileHeaderView:getContext	()Landroid/content/Context;
    //   417: invokevirtual 210	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   420: ldc 216
    //   422: invokestatic 222	android/graphics/BitmapFactory:decodeResource	(Landroid/content/res/Resources;I)Landroid/graphics/Bitmap;
    //   425: astore_2
    //   426: goto -175 -> 251
    //   429: aload_2
    //   430: aload_0
    //   431: getfield 18	com/tencent/mobileqq/profile/view/ProfileHeaderView$3:this$0	Lcom/tencent/mobileqq/profile/view/ProfileHeaderView;
    //   434: invokevirtual 207	com/tencent/mobileqq/profile/view/ProfileHeaderView:getContext	()Landroid/content/Context;
    //   437: invokevirtual 210	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   440: ldc 223
    //   442: invokevirtual 46	android/content/res/Resources:getDimensionPixelSize	(I)I
    //   445: invokevirtual 215	com/tencent/mobileqq/avatar/dynamicavatar/DynamicAvatarView:setTextSize	(I)V
    //   448: goto -38 -> 410
    //   451: iconst_2
    //   452: aload_0
    //   453: getfield 20	com/tencent/mobileqq/profile/view/ProfileHeaderView$3:val$type	I
    //   456: if_icmpne +10 -> 466
    //   459: invokestatic 227	aqhu:aH	()Landroid/graphics/Bitmap;
    //   462: astore_2
    //   463: goto -212 -> 251
    //   466: invokestatic 230	aqhu:G	()Landroid/graphics/Bitmap;
    //   469: astore_2
    //   470: goto -219 -> 251
    //   473: astore_2
    //   474: aload 4
    //   476: astore_2
    //   477: goto -226 -> 251
    //   480: astore 4
    //   482: aload_2
    //   483: astore_3
    //   484: goto -198 -> 286
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	487	0	this	3
    //   20	124	1	i	int
    //   36	434	2	localObject1	Object
    //   473	1	2	localOutOfMemoryError	java.lang.OutOfMemoryError
    //   476	7	2	localException1	java.lang.Exception
    //   4	480	3	localObject2	Object
    //   1	157	4	localOptions	android.graphics.BitmapFactory.Options
    //   284	191	4	localException2	java.lang.Exception
    //   480	1	4	localException3	java.lang.Exception
    //   6	146	5	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   104	163	284	java/lang/Exception
    //   410	426	473	java/lang/OutOfMemoryError
    //   169	190	480	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profile.view.ProfileHeaderView.3
 * JD-Core Version:    0.7.0.1
 */