package com.tencent.mobileqq.emoticonview;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import android.widget.EditText;
import com.tencent.image.GifDrawable;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emosm.EmosmUtils;
import com.tencent.mobileqq.emoticon.EmojiManager;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.magicface.magicfaceaction.ActionGlobalData;
import com.tencent.mobileqq.magicface.service.MagicfaceActionManager;
import com.tencent.mobileqq.model.EmoticonManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vaswebviewplugin.EmojiHomeUiPlugin;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class PicEmoticonInfo
  extends EmoticonInfo
{
  public static final int b = 0;
  public static final int e = 1;
  public static final int f = 2;
  public static final int g = 3;
  private static final String h = "PicEmoticonInfo";
  public int a;
  private ColorDrawable jdField_a_of_type_AndroidGraphicsDrawableColorDrawable = new ColorDrawable();
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable = null;
  public Emoticon a;
  public boolean a;
  private Drawable b;
  public boolean b;
  public int h;
  private String i;
  
  public PicEmoticonInfo(String paramString)
  {
    this.jdField_b_of_type_Boolean = false;
    this.jdField_b_of_type_AndroidGraphicsDrawableDrawable = null;
    this.i = paramString;
    if ((this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null) || (this.jdField_b_of_type_AndroidGraphicsDrawableDrawable == null))
    {
      paramString = BaseApplication.getContext().getResources();
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramString.getDrawable(2130838957);
      this.jdField_b_of_type_AndroidGraphicsDrawableDrawable = paramString.getDrawable(2130838958);
    }
  }
  
  private Drawable a(Context paramContext)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.jobType == 1) {}
    for (Object localObject = EmosmUtils.getEmoticonPreviewPath(this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.epId, this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.eId);; localObject = EmosmUtils.getEmoticonAIOPreviewPath(this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.epId, this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.eId))
    {
      if (localObject == null) {
        break label99;
      }
      BitmapFactory.Options localOptions = new BitmapFactory.Options();
      localOptions.inDensity = 320;
      localObject = BitmapFactory.decodeFile((String)localObject, localOptions);
      if (localObject == null) {
        break label99;
      }
      try
      {
        paramContext = new BitmapDrawable(paramContext.getResources(), (Bitmap)localObject);
        return paramContext;
      }
      catch (OutOfMemoryError paramContext)
      {
        paramContext.printStackTrace();
      }
    }
    label99:
    return this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
  }
  
  public static String a(Emoticon paramEmoticon)
  {
    if (paramEmoticon == null) {
      return null;
    }
    return paramEmoticon.epId + "_" + paramEmoticon.eId;
  }
  
  public static void a(URLDrawable paramURLDrawable)
  {
    if (paramURLDrawable != null)
    {
      Object localObject = paramURLDrawable.getCurrDrawable();
      if ((localObject != null) && ((localObject instanceof GifDrawable)))
      {
        localObject = ((GifDrawable)localObject).getImage();
        if ((localObject != null) && ((localObject instanceof VoiceGifImage)))
        {
          ((VoiceGifImage)localObject).b();
          ((VoiceGifImage)localObject).a();
          paramURLDrawable.invalidateSelf();
          if (QLog.isColorLevel()) {
            QLog.d("PicEmoticonInfo", 2, "soundgif startSoundDrawablePlay start");
          }
        }
      }
    }
  }
  
  public static void b(URLDrawable paramURLDrawable)
  {
    if (paramURLDrawable != null)
    {
      paramURLDrawable = paramURLDrawable.getCurrDrawable();
      if ((paramURLDrawable != null) && ((paramURLDrawable instanceof GifDrawable)))
      {
        paramURLDrawable = ((GifDrawable)paramURLDrawable).getImage();
        if ((paramURLDrawable != null) && ((paramURLDrawable instanceof VoiceGifImage)))
        {
          ((VoiceGifImage)paramURLDrawable).b();
          if (QLog.isColorLevel()) {
            QLog.d("PicEmoticonInfo", 2, "soundgif stopSoundDrawablePlay stop");
          }
        }
      }
    }
  }
  
  public Drawable a(Context paramContext, float paramFloat)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataEmoticon != null) {
      try
      {
        paramContext = new URL("emotion_pic", "panel_preview", a(this.jdField_a_of_type_ComTencentMobileqqDataEmoticon));
        paramContext = URLDrawable.getDrawable(paramContext, this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable, this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable, false);
        paramContext.setTag(this.jdField_a_of_type_ComTencentMobileqqDataEmoticon);
        paramContext.addHeader("my_uin", this.i);
        paramContext.addHeader("emo_tasks", Integer.toString(2));
        return paramContext;
      }
      catch (MalformedURLException paramContext)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("PicEmoticonInfo", 2, "getDrawable ,", paramContext);
          }
          paramContext = null;
        }
      }
    }
    return this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  }
  
  public URLDrawable a()
  {
    Object localObject1 = null;
    if (this.jdField_a_of_type_ComTencentMobileqqDataEmoticon == null) {}
    for (;;)
    {
      return localObject1;
      String str = EmosmUtils.getEmoticonAIOPreviewPath(this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.epId, this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.eId);
      if (str == null) {
        continue;
      }
      try
      {
        localObject1 = new URL("emotion_pic", "aio_preview", a(this.jdField_a_of_type_ComTencentMobileqqDataEmoticon));
        URLDrawable localURLDrawable = URLDrawable.getDrawable((URL)localObject1, this.jdField_a_of_type_AndroidGraphicsDrawableDrawable, this.jdField_b_of_type_AndroidGraphicsDrawableDrawable, false);
        localObject1 = localURLDrawable;
        if (localURLDrawable.getStatus() == 1) {
          continue;
        }
        localURLDrawable.setTag(this.jdField_a_of_type_ComTencentMobileqqDataEmoticon);
        localURLDrawable.addHeader("my_uin", this.i);
        localObject1 = localURLDrawable;
        if (!FileUtil.a(str)) {
          continue;
        }
        try
        {
          localURLDrawable.downloadImediatly();
          return localURLDrawable;
        }
        catch (OutOfMemoryError localOutOfMemoryError)
        {
          Object localObject2 = localURLDrawable;
        }
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("PicEmoticonInfo", 2, "getBigDrawable oom,drawableID=" + this.d);
        return localURLDrawable;
      }
      catch (MalformedURLException localMalformedURLException)
      {
        for (;;)
        {
          localMalformedURLException.printStackTrace();
          Object localObject3 = null;
        }
      }
    }
  }
  
  public URLDrawable a(Context paramContext, float paramFloat)
  {
    if (a()) {
      return b();
    }
    return a(true);
  }
  
  public URLDrawable a(boolean paramBoolean)
  {
    Object localObject2 = null;
    int j = 4;
    boolean bool2 = false;
    if (this.jdField_a_of_type_ComTencentMobileqqDataEmoticon == null) {
      return localObject2;
    }
    Object localObject5 = BaseApplication.getContext();
    int k = NetworkUtil.a((Context)localObject5);
    Object localObject1;
    if ((k == 1) || (k == 3) || (k == 4) || (this.h == 2) || (paramBoolean))
    {
      localObject1 = "big_img";
      if (!this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.isSound) {
        break label437;
      }
      j = 12;
      localObject1 = "big_sound";
    }
    label419:
    label434:
    label437:
    for (paramBoolean = false;; paramBoolean = true) {
      for (;;)
      {
        Object localObject4 = Integer.toString(j);
        boolean bool1 = paramBoolean;
        localObject2 = localObject1;
        localObject1 = localObject4;
        try
        {
          for (;;)
          {
            localObject2 = new URL("emotion_pic", (String)localObject2, a(this.jdField_a_of_type_ComTencentMobileqqDataEmoticon));
            boolean bool3 = b();
            paramBoolean = bool2;
            if (c())
            {
              paramBoolean = bool2;
              if (!bool3) {
                paramBoolean = true;
              }
            }
            if (2 != this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.jobType) {
              break label434;
            }
            paramBoolean = c();
            if (!paramBoolean) {
              break label419;
            }
            localObject4 = a((Context)localObject5);
            localObject5 = localObject4;
            localObject4 = URLDrawable.getDrawable((URL)localObject2, (Drawable)localObject5, (Drawable)localObject4, bool1);
            localObject2 = localObject4;
            if (((URLDrawable)localObject4).getStatus() == 1) {
              break;
            }
            ((URLDrawable)localObject4).setTag(this.jdField_a_of_type_ComTencentMobileqqDataEmoticon);
            ((URLDrawable)localObject4).addHeader("my_uin", this.i);
            ((URLDrawable)localObject4).addHeader("emo_tasks", (String)localObject1);
            ((URLDrawable)localObject4).addHeader("image_dl_extra_info", Boolean.toString(paramBoolean));
            if (QLog.isColorLevel()) {
              QLog.d("PicEmoticonInfo", 2, "b.getStatus=" + ((URLDrawable)localObject4).getStatus() + " isBigImageExist=" + bool3 + " e.epId=" + this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.epId + " e.eId=" + this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.eId);
            }
            localObject2 = localObject4;
            if (!bool3) {
              break;
            }
            try
            {
              ((URLDrawable)localObject4).downloadImediatly();
              return localObject4;
            }
            catch (OutOfMemoryError localOutOfMemoryError)
            {
              localObject2 = localObject4;
            }
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.e("PicEmoticonInfo", 2, "getBigDrawable oom,drawableID=" + this.d);
            return localObject4;
            String str = Integer.toString(1);
            localObject2 = "aio_preview";
            bool1 = true;
          }
        }
        catch (MalformedURLException localMalformedURLException)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.d("PicEmoticonInfo", 2, "getDrawable ,", localMalformedURLException);
            }
            Object localObject3 = null;
            continue;
            localObject5 = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
            localObject4 = this.jdField_b_of_type_AndroidGraphicsDrawableDrawable;
          }
        }
      }
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, Context paramContext, EditText paramEditText, SessionInfo paramSessionInfo)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataEmoticon == null) {}
    do
    {
      return;
      if ((this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.jobType != 2) || (!(paramContext instanceof ChatActivity))) {
        break label244;
      }
      paramEditText = ((EmoticonManager)paramQQAppInterface.getManager(13)).a(this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.epId);
      ReportController.b(paramQQAppInterface, "CliOper", "", "", "MbFasong", "MbIDDianji", 0, 0, this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.epId, "", "", "");
      if (((paramEditText != null) && ((2 != paramEditText.status) || (!paramEditText.valid))) || (this.jdField_a_of_type_Boolean))
      {
        EmojiHomeUiPlugin.openEmojiDetailPage(((ChatActivity)paramContext).getActivity(), paramQQAppInterface.getAccount(), 8, this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.epId, paramQQAppInterface.getSid(), false);
        return;
      }
      paramEditText = (EmojiManager)paramQQAppInterface.getManager(39);
      if (!paramEditText.a()) {
        break label269;
      }
      if (paramEditText.a(this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.epId, Boolean.valueOf(false))) {
        break;
      }
      ChatActivityUtils.a(paramContext, 2131364109, 0);
      paramQQAppInterface = paramQQAppInterface.a(ChatActivity.class);
    } while (paramQQAppInterface == null);
    paramQQAppInterface.obtainMessage(10).sendToTarget();
    paramQQAppInterface.obtainMessage(21).sendToTarget();
    return;
    paramEditText = MagicfaceActionManager.a(this.jdField_a_of_type_ComTencentMobileqqDataEmoticon, 0);
    if ((paramEditText != null) && (paramEditText.jdField_a_of_type_Boolean)) {}
    for (this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.magicValue = "value=1";; this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.magicValue = "null")
    {
      label244:
      ChatActivityFacade.a(paramQQAppInterface, paramContext, paramSessionInfo, this.jdField_a_of_type_ComTencentMobileqqDataEmoticon);
      return;
    }
    label269:
    ChatActivityUtils.a(paramContext, 2131364108);
  }
  
  public void a(QQAppInterface paramQQAppInterface, Context paramContext, EditText paramEditText, SessionInfo paramSessionInfo, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataEmoticon == null) {}
    do
    {
      return;
      if ((this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.jobType != 2) || (!paramBoolean) || (!(paramContext instanceof ChatActivity)) || (((EmojiManager)paramQQAppInterface.getManager(39)).a(this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.epId, Boolean.valueOf(false)))) {
        break;
      }
      ChatActivityUtils.a(paramContext, 2131364109, 0);
      paramQQAppInterface = paramQQAppInterface.a(ChatActivity.class);
    } while (paramQQAppInterface == null);
    paramQQAppInterface.obtainMessage(10).sendToTarget();
    paramQQAppInterface.obtainMessage(21).sendToTarget();
    return;
    ChatActivityFacade.a(paramQQAppInterface, paramContext, paramSessionInfo, this.jdField_a_of_type_ComTencentMobileqqDataEmoticon);
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_ComTencentMobileqqDataEmoticon != null) && (this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.isSound);
  }
  
  public URLDrawable b()
  {
    Object localObject1 = null;
    if (this.jdField_a_of_type_ComTencentMobileqqDataEmoticon == null) {}
    for (;;)
    {
      return localObject1;
      String str = Integer.toString(12);
      try
      {
        localObject1 = new URL("emotion_pic", "big_sound", a(this.jdField_a_of_type_ComTencentMobileqqDataEmoticon));
        URLDrawable localURLDrawable = URLDrawable.getDrawable((URL)localObject1, this.jdField_a_of_type_AndroidGraphicsDrawableDrawable, this.jdField_b_of_type_AndroidGraphicsDrawableDrawable, true);
        localObject1 = localURLDrawable;
        if (localURLDrawable.getStatus() == 1) {
          continue;
        }
        localURLDrawable.setTag(this.jdField_a_of_type_ComTencentMobileqqDataEmoticon);
        localURLDrawable.addHeader("my_uin", this.i);
        localURLDrawable.addHeader("emo_tasks", str);
        localObject1 = localURLDrawable;
        if (!b()) {
          continue;
        }
        try
        {
          localURLDrawable.downloadImediatly();
          return localURLDrawable;
        }
        catch (OutOfMemoryError localOutOfMemoryError)
        {
          localOutOfMemoryError.printStackTrace();
          return localURLDrawable;
        }
      }
      catch (MalformedURLException localMalformedURLException)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("PicEmoticonInfo", 2, "getDrawable ,", localMalformedURLException);
          }
          Object localObject2 = null;
        }
      }
    }
  }
  
  public boolean b()
  {
    boolean bool2 = true;
    if (this.jdField_a_of_type_ComTencentMobileqqDataEmoticon == null) {
      return false;
    }
    Object localObject;
    boolean bool1;
    if (this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.jobType == 1)
    {
      localObject = EmosmUtils.getQFaceGifPath(this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.epId, this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.eId);
      if (localObject == null) {
        break label198;
      }
      localObject = new File((String)localObject);
      if ((!((File)localObject).exists()) || (!((File)localObject).isFile())) {
        break label176;
      }
      bool1 = true;
    }
    for (;;)
    {
      label75:
      int j;
      if ((this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.isSound) && (bool1))
      {
        localObject = EmosmUtils.getEmoticonSoundPath(this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.epId, this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.eId);
        if (localObject == null) {
          break label193;
        }
        localObject = new File((String)localObject);
        if ((((File)localObject).exists()) && (((File)localObject).isFile())) {
          j = 1;
        }
      }
      for (;;)
      {
        label142:
        if ((bool1) && (j != 0)) {}
        for (bool1 = bool2;; bool1 = false)
        {
          return bool1;
          localObject = EmosmUtils.getEmoticonEncryptPath(this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.epId, this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.eId);
          break;
          label176:
          bool1 = false;
          break label75;
          j = 0;
          break label142;
        }
        return bool1;
        label193:
        j = 0;
      }
      label198:
      bool1 = false;
    }
  }
  
  public boolean c()
  {
    boolean bool = true;
    if (this.jdField_a_of_type_ComTencentMobileqqDataEmoticon == null) {
      return false;
    }
    Object localObject;
    if (this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.jobType == 1)
    {
      localObject = EmosmUtils.getEmoticonPreviewPath(this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.epId, this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.eId);
      label40:
      if (localObject == null) {
        break label88;
      }
      localObject = new File((String)localObject);
      if ((!((File)localObject).exists()) || (!((File)localObject).isFile())) {
        break label90;
      }
    }
    for (;;)
    {
      return bool;
      localObject = EmosmUtils.getEmoticonAIOPreviewPath(this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.epId, this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.eId);
      break label40;
      label88:
      break;
      label90:
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.PicEmoticonInfo
 * JD-Core Version:    0.7.0.1
 */