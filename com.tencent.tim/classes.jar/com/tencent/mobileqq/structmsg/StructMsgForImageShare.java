package com.tencent.mobileqq.structmsg;

import aegu;
import akwt;
import akwt.a;
import akxw;
import akyf;
import amzo;
import anbi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import anot;
import anqu;
import anqv;
import anrd;
import anrt;
import ansf;
import ansr;
import ansu;
import anux;
import aoiz;
import aooi;
import aool;
import aoop;
import aqhq;
import aqhu;
import com.qq.taf.jce.HexUtil;
import com.tencent.image.GifDrawable;
import com.tencent.image.SafeBitmapFactory;
import com.tencent.image.URLDrawable;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.activity.photo.ImageInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.structmsg.view.StructMsgItemTitle;
import com.tencent.mobileqq.widget.BubbleImageView;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import jqg;
import top;
import ujs;
import wlz;
import wte;

public class StructMsgForImageShare
  extends AbsShareMsg
{
  public static final int SHARE_IMAGE_FREVIEW_MAX_SZIE = 140;
  private static View.OnClickListener fM = new anrt();
  public String bigUrl;
  public int height;
  public int mImageBizType;
  public int mIsSend = 1;
  public int mMsgType;
  public long mUniseq;
  public String rawUrl;
  public int thumbHeight;
  public String thumbUrl;
  public int thumbWidth;
  public int width;
  
  public StructMsgForImageShare()
  {
    this.mMsgServiceID = 5;
  }
  
  public StructMsgForImageShare(Bundle paramBundle)
  {
    super(paramBundle);
    if (paramBundle.getInt("req_type", 1) != 5) {
      return;
    }
    this.mMsgServiceID = 5;
    anqv localanqv = anrd.a(0);
    localanqv.Ro(paramBundle.getString("image_url"));
    this.mStructMsgItemLists.add(localanqv);
    this.thumbWidth = paramBundle.getInt("struct_share_key_thumb_width", 0);
    this.thumbHeight = paramBundle.getInt("struct_share_key_thumb_height", 0);
  }
  
  public StructMsgForImageShare(ansf paramansf)
  {
    super(paramansf);
  }
  
  public static boolean resendAndUploadImageShare(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord, StructMsgForImageShare paramStructMsgForImageShare)
  {
    if (paramStructMsgForImageShare == null) {}
    do
    {
      return false;
      paramStructMsgForImageShare = paramStructMsgForImageShare.getFirstImageElement();
      if (paramStructMsgForImageShare != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("StructMsg", 2, "handleAppShareAction firstImageElement NULL!!!");
    return false;
    String str = paramQQAppInterface.getCurrentAccountUin();
    MessageRecord localMessageRecord = anbi.e(paramMessageRecord);
    paramQQAppInterface.b().b(localMessageRecord, str);
    aool localaool = new aool();
    localaool.mSelfUin = str;
    localaool.mPeerUin = paramMessageRecord.frienduin;
    localaool.mUinType = paramMessageRecord.istroop;
    localaool.mFileType = 1;
    localaool.mUniseq = localMessageRecord.uniseq;
    localaool.cNy = true;
    localaool.mBusiType = 1030;
    localaool.dQ = paramStructMsgForImageShare.cij;
    paramQQAppInterface.a().a(localaool, localMessageRecord);
    return true;
  }
  
  public static final String scaleLocalImage(Context paramContext, ImageInfo paramImageInfo, String paramString, int paramInt)
  {
    if ((paramContext == null) || (paramImageInfo == null) || (paramString == null)) {
      paramImageInfo = null;
    }
    String str1;
    long l1;
    do
    {
      return paramImageInfo;
      File localFile = new File(paramString);
      if (!localFile.exists())
      {
        if (QLog.isColorLevel()) {
          QLog.d("StructMsg", 2, "handleAppShareAction mShareImageUrl NULL!!!");
        }
        return null;
      }
      String str2 = null;
      str1 = str2;
      for (;;)
      {
        try
        {
          if (!GifDrawable.isGifFile(localFile)) {
            continue;
          }
          str1 = str2;
          l1 = localFile.length();
          if (l1 >= 12582912L) {
            continue;
          }
          paramContext = paramString;
        }
        catch (Exception paramImageInfo)
        {
          boolean bool;
          paramContext = str1;
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("StructMsg", 2, paramImageInfo.getMessage());
          paramContext = str1;
          continue;
          paramImageInfo = paramContext;
        }
        if (!TextUtils.isEmpty(paramContext)) {
          continue;
        }
        return null;
        str1 = str2;
        localFile = new File(AbsStructMsg.chW);
        str1 = str2;
        if (!localFile.exists())
        {
          str1 = str2;
          localFile.mkdirs();
        }
        str1 = str2;
        str2 = AbsStructMsg.chW + System.currentTimeMillis() + ".jpg";
        str1 = str2;
        bool = aqhu.a(4, paramContext, paramString, str2, true, paramImageInfo, paramInt);
        paramContext = str2;
        if (!bool) {
          paramContext = paramString;
        }
      }
    } while (!QLog.isColorLevel());
    try
    {
      paramImageInfo = new BitmapFactory.Options();
      paramImageInfo.inJustDecodeBounds = true;
      SafeBitmapFactory.decodeFile(paramString, paramImageInfo);
      paramInt = paramImageInfo.outWidth;
      int i = paramImageInfo.outHeight;
      SafeBitmapFactory.decodeFile(paramContext, paramImageInfo);
      int j = paramImageInfo.outWidth;
      int k = paramImageInfo.outHeight;
      l1 = new File(paramString).length();
      long l2 = new File(paramContext).length();
      QLog.d("StructMsg", 2, "srcBmp = " + paramString + ", length = " + l1 + ", srcWidth = " + paramInt + ", srcHeight = " + i + ", destBmp = " + paramContext + ", length = " + l2 + ", destWidth = " + j + ", distHeight = " + k);
      return paramContext;
    }
    catch (Exception paramImageInfo)
    {
      QLog.d("StructMsg", 2, paramImageInfo.getMessage());
    }
    return paramContext;
  }
  
  public static boolean sendAndUploadImageShare(QQAppInterface paramQQAppInterface, StructMsgForImageShare paramStructMsgForImageShare, String paramString1, int paramInt1, String paramString2, int paramInt2)
  {
    return sendAndUploadImageShare(paramQQAppInterface, paramStructMsgForImageShare, paramString1, paramInt1, paramString2, paramInt2, null, false);
  }
  
  public static boolean sendAndUploadImageShare(QQAppInterface paramQQAppInterface, StructMsgForImageShare paramStructMsgForImageShare, String paramString1, int paramInt1, String paramString2, int paramInt2, akyf paramakyf, boolean paramBoolean)
  {
    if (paramStructMsgForImageShare == null) {
      return false;
    }
    if ((paramString1 == null) || (paramInt1 < 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("StructMsg", 2, "handleAppShareAction toUin is NULL!!!");
      }
      return false;
    }
    ansu localansu = paramStructMsgForImageShare.getFirstImageElement();
    if (localansu == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("StructMsg", 2, "handleAppShareAction firstImageElement NULL!!!");
      }
      return false;
    }
    int i = amzo.seq;
    amzo.seq = i + 1;
    long l = i;
    String str = paramQQAppInterface.getCurrentAccountUin();
    if (((paramInt1 != 1000) && (paramInt1 != 1020) && (paramInt1 != 1004)) || (TextUtils.isEmpty(paramString2))) {
      paramString2 = str;
    }
    for (;;)
    {
      localansu.filesize = 0L;
      paramString2 = anbi.a(paramQQAppInterface, str, paramString1, paramString2, paramInt1, l, paramStructMsgForImageShare);
      wte.a().i(paramString2.uniseq, paramStructMsgForImageShare.uniseq, paramStructMsgForImageShare.forwardID);
      if (top.eD(paramInt1) == 1032) {
        aegu.a(paramQQAppInterface, paramString2, paramString1, paramInt1, paramInt2);
      }
      if (!paramStructMsgForImageShare.checkImageSharePic(paramQQAppInterface.getApp())) {
        return false;
      }
      if (aqhq.rq(localansu.cij))
      {
        paramStructMsgForImageShare = HexUtil.bytes2HexStr(MD5.getFileMd5(localansu.cij));
        if (paramStructMsgForImageShare == null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("StructMsg", 2, "handleAppShareAction MD5 NULL!!!");
          }
          return false;
        }
        localansu.mMd5 = paramStructMsgForImageShare;
        paramStructMsgForImageShare = aoop.b(paramStructMsgForImageShare, 1);
        if (paramStructMsgForImageShare != null) {
          break label362;
        }
        paramStructMsgForImageShare = null;
        if (!aoiz.hasFile(paramStructMsgForImageShare))
        {
          paramStructMsgForImageShare = aoiz.getFilePath(paramStructMsgForImageShare);
          aqhq.copyFile(localansu.cij, paramStructMsgForImageShare);
        }
      }
      paramStructMsgForImageShare = new aool();
      paramStructMsgForImageShare.mSelfUin = str;
      paramStructMsgForImageShare.mPeerUin = paramString1;
      paramStructMsgForImageShare.mUinType = paramInt1;
      paramStructMsgForImageShare.mFileType = 1;
      paramStructMsgForImageShare.mUniseq = paramString2.uniseq;
      paramStructMsgForImageShare.cNy = true;
      paramStructMsgForImageShare.mBusiType = 1030;
      paramStructMsgForImageShare.dQ = localansu.cij;
      paramStructMsgForImageShare.b = paramakyf;
      if (paramBoolean)
      {
        paramStructMsgForImageShare.cMb = false;
        paramStructMsgForImageShare.cNI = true;
      }
      for (;;)
      {
        paramQQAppInterface.a().a(paramStructMsgForImageShare);
        return true;
        label362:
        paramStructMsgForImageShare = paramStructMsgForImageShare.toString();
        break;
        paramQQAppInterface.b().b(paramString2, str);
      }
    }
  }
  
  public static boolean sendAndUploadImageShareHotPic(QQAppInterface paramQQAppInterface, StructMsgForImageShare paramStructMsgForImageShare, String paramString1, int paramInt1, String paramString2, akwt.a parama, int paramInt2)
  {
    if (paramStructMsgForImageShare == null) {
      return false;
    }
    if ((paramString1 == null) || (paramInt1 < 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("StructMsg", 2, "handleAppShareAction toUin is NULL!!!");
      }
      return false;
    }
    ansu localansu = paramStructMsgForImageShare.getFirstImageElement();
    if (localansu == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("StructMsg", 2, "handleAppShareAction firstImageElement NULL!!!");
      }
      return false;
    }
    int i = amzo.seq;
    amzo.seq = i + 1;
    long l = i;
    String str = paramQQAppInterface.getCurrentAccountUin();
    if (((paramInt1 != 1000) && (paramInt1 != 1020) && (paramInt1 != 1004)) || (TextUtils.isEmpty(paramString2))) {
      paramString2 = str;
    }
    for (;;)
    {
      localansu.filesize = 0L;
      paramString2 = anbi.a(paramQQAppInterface, str, paramString1, paramString2, paramInt1, l, paramStructMsgForImageShare);
      akwt.a(paramString2, parama);
      if (top.eD(paramInt1) == 1032) {
        aegu.a(paramQQAppInterface, paramString2, paramString1, paramInt1, paramInt2);
      }
      paramQQAppInterface.b().b(paramString2, str);
      if (aqhq.rq(localansu.cij))
      {
        paramStructMsgForImageShare = HexUtil.bytes2HexStr(MD5.getFileMd5(localansu.cij));
        if (paramStructMsgForImageShare == null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("StructMsg", 2, "handleAppShareAction MD5 NULL!!!");
          }
          return false;
        }
        paramStructMsgForImageShare = aoop.b(paramStructMsgForImageShare, 1);
        if (paramStructMsgForImageShare != null) {
          break label323;
        }
      }
      label323:
      for (paramStructMsgForImageShare = null;; paramStructMsgForImageShare = paramStructMsgForImageShare.toString())
      {
        if (!aoiz.hasFile(paramStructMsgForImageShare))
        {
          paramStructMsgForImageShare = aoiz.getFilePath(paramStructMsgForImageShare);
          aqhq.copyFile(localansu.cij, paramStructMsgForImageShare);
        }
        paramStructMsgForImageShare = new aool();
        paramStructMsgForImageShare.mSelfUin = str;
        paramStructMsgForImageShare.mPeerUin = paramString1;
        paramStructMsgForImageShare.mUinType = paramInt1;
        paramStructMsgForImageShare.mFileType = 1;
        paramStructMsgForImageShare.mUniseq = paramString2.uniseq;
        paramStructMsgForImageShare.cNy = true;
        paramStructMsgForImageShare.mBusiType = 1030;
        paramStructMsgForImageShare.dQ = localansu.cij;
        paramQQAppInterface.a().a(paramStructMsgForImageShare, paramString2);
        return true;
      }
    }
  }
  
  public boolean checkImageSharePic(Context paramContext)
  {
    ansu localansu = getFirstImageElement();
    if (localansu != null)
    {
      if (localansu.d == null) {
        localansu.d = this;
      }
      Object localObject2 = localansu.a();
      URLDrawable localURLDrawable = ForwardUtils.a(paramContext, (MessageForPic)localObject2);
      if (new File(((MessageForPic)localObject2).path).exists())
      {
        localansu.cij = ((MessageForPic)localObject2).path;
        if (TextUtils.isEmpty(localansu.cij))
        {
          if (QLog.isColorLevel()) {
            QLog.d("StructMsg", 2, "StructingMsgItemBuilder onMenuItemClicked forward imageElement.mShareImageUrl is null!!!");
          }
          return false;
        }
      }
      else
      {
        Object localObject1 = null;
        paramContext = localURLDrawable.getURL().toString();
        if (aoiz.hasFile(paramContext))
        {
          localObject2 = aoiz.getFile(paramContext);
          paramContext = localObject1;
          if (localObject2 != null)
          {
            paramContext = localObject1;
            if (((File)localObject2).exists()) {
              paramContext = ((File)localObject2).getAbsolutePath();
            }
          }
        }
        for (;;)
        {
          localansu.cij = paramContext;
          break;
          localObject2 = aoiz.getFile(aoop.a((akxw)localObject2, 65537).toString());
          paramContext = localObject1;
          if (localObject2 != null)
          {
            paramContext = localObject1;
            if (((File)localObject2).exists()) {
              paramContext = ((File)localObject2).getAbsolutePath();
            }
          }
        }
      }
      if (!aoiz.hasFile(localURLDrawable.getURL().toString())) {
        localURLDrawable.startDownload();
      }
      return true;
    }
    if (QLog.isColorLevel()) {
      QLog.d("StructMsg", 2, "StructingMsgItemBuilder onMenuItemClicked forward imageElement is null!!!");
    }
    return false;
  }
  
  public ansu getFirstImageElement()
  {
    if (this.mStructMsgItemLists != null)
    {
      int i = 0;
      while (i < this.mStructMsgItemLists.size())
      {
        Object localObject = (anqu)this.mStructMsgItemLists.get(i);
        if ((localObject instanceof anqv))
        {
          localObject = (anqv)localObject;
          if (((anqv)localObject).rz != null)
          {
            int j = 0;
            while (j < ((anqv)localObject).rz.size())
            {
              anqu localanqu = (anqu)((anqv)localObject).rz.get(j);
              if ((localanqu != null) && ((localanqu instanceof ansu))) {
                return (ansu)localanqu;
              }
              j += 1;
            }
          }
        }
        i += 1;
      }
    }
    return null;
  }
  
  public View.OnClickListener getOnClickListener()
  {
    return fM;
  }
  
  public View getPreDialogView(Context paramContext, View paramView)
  {
    paramView = paramContext.getResources();
    int i = (int)paramView.getDisplayMetrics().density;
    paramContext = new ImageView(paramContext);
    paramContext.setScaleType(ImageView.ScaleType.FIT_CENTER);
    paramContext.setMaxHeight(i * 140);
    paramContext.setAdjustViewBounds(true);
    paramContext.setPadding(0, 10, 0, 10);
    Object localObject1 = new LinearLayout.LayoutParams(-1, -2);
    ((LinearLayout.LayoutParams)localObject1).gravity = 17;
    paramContext.setLayoutParams((ViewGroup.LayoutParams)localObject1);
    paramContext.setMinimumHeight(i * 120);
    if (ujs.aTl) {}
    paramView = paramView.getDrawable(2130851465);
    localObject1 = getFirstImageElement();
    if ((localObject1 != null) && (((ansu)localObject1).cij != null))
    {
      Object localObject2 = ((ansu)localObject1).cij;
      if ((!((String)localObject2).startsWith("http://")) && (!((String)localObject2).startsWith("https://")))
      {
        localObject2 = jqg.d(((ansu)localObject1).cij, i * 140);
        if (localObject2 != null)
        {
          paramContext.setImageBitmap(aqhu.a((Bitmap)localObject2, new File(((ansu)localObject1).cij)));
          return paramContext;
        }
        paramContext.setImageDrawable(paramView);
        return paramContext;
      }
      paramContext.setImageDrawable(URLDrawable.getDrawable((String)localObject2, paramView, paramView));
      return paramContext;
    }
    paramContext.setImageDrawable(paramView);
    return paramContext;
  }
  
  public View getView(Context paramContext, View paramView, wlz paramwlz, Bundle paramBundle)
  {
    if (this.mMsgException)
    {
      paramContext = getVersionExceptionView(paramContext, paramView, paramwlz, paramBundle);
      paramContext.setId(2131378856);
      paramContext.setTag(2131378856, this);
      return paramContext;
    }
    paramwlz = (ViewGroup)super.getView(paramContext, paramView, paramwlz, paramBundle);
    ansu localansu = getFirstImageElement();
    if (localansu != null)
    {
      localansu.d = this;
      if ((paramwlz.getChildCount() == 1) && ((paramwlz.getChildAt(0) instanceof BubbleImageView)) && (localansu.useCustomSize())) {
        localansu.a(paramContext, paramwlz.getChildAt(0), paramBundle);
      }
    }
    else
    {
      paramContext = paramwlz.getLayoutParams();
      if (paramContext != null) {
        break label168;
      }
      paramContext = new LinearLayout.LayoutParams(-2, -2);
    }
    for (;;)
    {
      paramwlz.setLayoutParams(paramContext);
      paramwlz.setBackgroundDrawable(null);
      paramwlz.setId(2131378856);
      paramwlz.setTag(2131378856, this);
      return paramwlz;
      paramwlz.addView(localansu.a(paramContext, paramView, paramBundle));
      break;
      label168:
      paramContext.height = -2;
      paramContext.width = -2;
    }
  }
  
  protected boolean parseContentNode(ansf paramansf)
  {
    boolean bool2 = false;
    boolean bool1;
    if (paramansf == null)
    {
      bool1 = true;
      return bool1;
    }
    if ("item".equals(paramansf.name)) {}
    for (Object localObject = paramansf.getAttribute("layout");; localObject = anrd.a(paramansf.name))
    {
      try
      {
        if (!TextUtils.isEmpty((CharSequence)localObject)) {}
        for (int i = Integer.parseInt((String)localObject);; i = 0)
        {
          localObject = anrd.a(i);
          bool1 = bool2;
          if (localObject == null) {
            break;
          }
          bool1 = bool2;
          if (!((anqu)localObject).a(paramansf)) {
            break;
          }
          addItem((anqu)localObject);
          return true;
        }
        if (!QLog.isColorLevel()) {
          break;
        }
      }
      catch (NumberFormatException paramansf)
      {
        bool1 = bool2;
      }
      QLog.d("StructMsg", 2, "Item layout value is " + 0);
      return false;
    }
  }
  
  public void readExternal(ObjectInput paramObjectInput)
    throws IOException
  {
    int m = 0;
    for (;;)
    {
      int n;
      Object localObject;
      int k;
      int j;
      try
      {
        n = paramObjectInput.readInt();
        this.mVersion = n;
        if (n == 1)
        {
          this.mMsgTemplateID = paramObjectInput.readInt();
          this.mMsgAction = paramObjectInput.readUTF();
          this.mMsgActionData = paramObjectInput.readUTF();
          this.mMsg_A_ActionData = paramObjectInput.readUTF();
          this.mMsg_I_ActionData = paramObjectInput.readUTF();
          this.mMsgUrl = paramObjectInput.readUTF();
          this.mMsgBrief = paramObjectInput.readUTF();
          this.mContentLayout = paramObjectInput.readInt();
          this.mContentCover = paramObjectInput.readUTF();
          this.mContentTitle = paramObjectInput.readUTF();
          this.mContentSummary = paramObjectInput.readUTF();
          localObject = anrd.a(this.mContentLayout);
          ((anqv)localObject).a(new ansr(this.mContentCover));
          ((anqv)localObject).a(new StructMsgItemTitle(this.mContentTitle));
          ((anqv)localObject).a(new anux(this.mContentSummary));
          addItem((anqu)localObject);
          this.mSourceAppid = paramObjectInput.readLong();
          this.mSourceIcon = paramObjectInput.readUTF();
          this.mSourceName = paramObjectInput.readUTF();
          this.mSourceUrl = paramObjectInput.readUTF();
          this.mSourceAction = paramObjectInput.readUTF();
          this.mSourceActionData = paramObjectInput.readUTF();
          this.mSource_A_ActionData = paramObjectInput.readUTF();
          this.mSource_I_ActionData = paramObjectInput.readUTF();
          this.fwFlag = paramObjectInput.readInt();
          if ((TextUtils.isEmpty(this.mSourceName)) && (TextUtils.isEmpty(this.mSourceIcon))) {
            break label999;
          }
          this.mHasSource = true;
          return;
        }
        if (n < 2) {
          break label994;
        }
        this.mMsgTemplateID = paramObjectInput.readInt();
        this.mMsgAction = paramObjectInput.readUTF();
        this.mMsgActionData = paramObjectInput.readUTF();
        this.mMsg_A_ActionData = paramObjectInput.readUTF();
        this.mMsg_I_ActionData = paramObjectInput.readUTF();
        this.mMsgUrl = paramObjectInput.readUTF();
        this.mMsgBrief = paramObjectInput.readUTF();
        int i1 = paramObjectInput.readInt();
        k = 0;
        i = 1;
        if (k < i1)
        {
          localObject = paramObjectInput.readUTF();
          if ("item".equals(localObject))
          {
            localObject = anrd.a(paramObjectInput.readInt());
            j = i;
            if (localObject == null) {
              break label1000;
            }
            ((anqu)localObject).readExternal(paramObjectInput);
            j = i;
            if (!TextUtils.isEmpty(((anqu)localObject).cgX))
            {
              ((anqu)localObject).chH = String.valueOf(i);
              j = i + 1;
            }
            ((anqu)localObject).uin = this.uin;
            addItem((anqu)localObject);
            break label1000;
          }
          anqu localanqu = anrd.a((String)localObject);
          localObject = localanqu;
          if (localanqu == null) {
            continue;
          }
          localObject = localanqu;
          if (!anqv.class.isInstance(localanqu)) {
            continue;
          }
          paramObjectInput.readInt();
          localObject = localanqu;
          continue;
        }
        this.mSourceAppid = paramObjectInput.readLong();
      }
      catch (IOException paramObjectInput)
      {
        if ((paramObjectInput.getMessage() != null) && (paramObjectInput.getMessage().equals("structmsg_version_error"))) {
          this.mMsgException = true;
        }
        paramObjectInput.printStackTrace();
        return;
      }
      this.mSourceIcon = paramObjectInput.readUTF();
      this.mSourceName = paramObjectInput.readUTF();
      this.mSourceUrl = paramObjectInput.readUTF();
      this.mSourceAction = paramObjectInput.readUTF();
      this.mSourceActionData = paramObjectInput.readUTF();
      this.mSource_A_ActionData = paramObjectInput.readUTF();
      this.mSource_I_ActionData = paramObjectInput.readUTF();
      this.fwFlag = paramObjectInput.readInt();
      this.mFlag = paramObjectInput.readInt();
      this.mHasSource = paramObjectInput.readBoolean();
      this.mCommentText = paramObjectInput.readUTF();
      if (n >= 3)
      {
        this.mCompatibleText = paramObjectInput.readUTF();
        this.msgId = paramObjectInput.readLong();
        this.mPromotionType = paramObjectInput.readInt();
        this.mPromotionMsg = paramObjectInput.readUTF();
        this.mPromotionMenus = paramObjectInput.readUTF();
        this.mPromotionMenuDestructiveIndex = paramObjectInput.readInt();
        i = m;
        while (i < this.mStructMsgItemLists.size())
        {
          localObject = (anqu)this.mStructMsgItemLists.get(i);
          ((anqu)localObject).msgId = this.msgId;
          ((anqu)localObject).mPromotionType = this.mPromotionType;
          i += 1;
        }
        if (n >= 5)
        {
          this.source_puin = paramObjectInput.readUTF();
          if (n >= 7)
          {
            this.adverSign = paramObjectInput.readInt();
            this.adverKey = paramObjectInput.readUTF();
            this.index = paramObjectInput.readUTF();
            this.index_name = paramObjectInput.readUTF();
            this.index_type = paramObjectInput.readUTF();
            if (n >= 16)
            {
              this.thumbWidth = paramObjectInput.readInt();
              this.thumbHeight = paramObjectInput.readInt();
              this.mImageBizType = paramObjectInput.readInt();
              if (n >= 20)
              {
                this.rawUrl = paramObjectInput.readUTF();
                if (n >= 21)
                {
                  this.bigUrl = paramObjectInput.readUTF();
                  this.thumbUrl = paramObjectInput.readUTF();
                  if (n >= 26)
                  {
                    this.width = paramObjectInput.readInt();
                    this.height = paramObjectInput.readInt();
                    return;
                    label994:
                    this.mMsgException = true;
                  }
                }
              }
            }
          }
        }
      }
      label999:
      return;
      label1000:
      k += 1;
      int i = j;
    }
  }
  
  public void report(Object paramObject)
  {
    ansu localansu = getFirstImageElement();
    if ((localansu == null) || (!localansu.useCustomSize())) {}
    do
    {
      do
      {
        return;
      } while (!(paramObject instanceof Long));
      anot.a(null, "dc00898", "", "", "0X800A26", "0X800A26", 0, 0, "", "", paramObject.toString(), ForwardUtils.cy(this.uinType));
    } while (!QLog.isColorLevel());
    QLog.d("StructMsg", 2, "大图曝光=0X800A26, appid=" + paramObject);
  }
  
  protected void setCompoundDrawable(TextView paramTextView, Drawable paramDrawable, Resources paramResources)
  {
    ansu localansu = getFirstImageElement();
    if ((localansu == null) || (!localansu.useCustomSize()))
    {
      super.setCompoundDrawable(paramTextView, paramDrawable, paramResources);
      return;
    }
    ThreadManagerV2.executeOnSubThread(new StructMsgForImageShare.2(this, paramDrawable, paramResources, paramTextView));
  }
  
  protected void toContentXml(AbsStructMsg.a parama)
    throws IOException
  {
    Iterator localIterator = iterator();
    while (localIterator.hasNext()) {
      ((anqu)localIterator.next()).a(parama);
    }
  }
  
  public void writeExternal(ObjectOutput paramObjectOutput)
    throws IOException
  {
    paramObjectOutput.writeInt(this.mMsgServiceID);
    paramObjectOutput.writeInt(this.mVersion);
    paramObjectOutput.writeInt(this.mMsgTemplateID);
    if (this.mMsgAction == null)
    {
      localObject = "";
      paramObjectOutput.writeUTF((String)localObject);
      if (this.mMsgActionData != null) {
        break label186;
      }
      localObject = "";
      label59:
      paramObjectOutput.writeUTF((String)localObject);
      if (this.mMsg_A_ActionData != null) {
        break label194;
      }
      localObject = "";
      label77:
      paramObjectOutput.writeUTF((String)localObject);
      if (this.mMsg_I_ActionData != null) {
        break label202;
      }
      localObject = "";
      label95:
      paramObjectOutput.writeUTF((String)localObject);
      if (this.mMsgUrl != null) {
        break label210;
      }
      localObject = "";
      label113:
      paramObjectOutput.writeUTF((String)localObject);
      if (this.mMsgBrief != null) {
        break label218;
      }
    }
    label186:
    label194:
    label202:
    label210:
    label218:
    for (Object localObject = "";; localObject = this.mMsgBrief)
    {
      paramObjectOutput.writeUTF((String)localObject);
      paramObjectOutput.writeInt(getItemCount());
      localObject = iterator();
      while (((Iterator)localObject).hasNext()) {
        ((anqu)((Iterator)localObject).next()).writeExternal(paramObjectOutput);
      }
      localObject = this.mMsgAction;
      break;
      localObject = this.mMsgActionData;
      break label59;
      localObject = this.mMsg_A_ActionData;
      break label77;
      localObject = this.mMsg_I_ActionData;
      break label95;
      localObject = this.mMsgUrl;
      break label113;
    }
    paramObjectOutput.writeLong(this.mSourceAppid);
    if (this.mSourceIcon == null)
    {
      localObject = "";
      paramObjectOutput.writeUTF((String)localObject);
      if (this.mSourceName != null) {
        break label707;
      }
      localObject = "";
      label265:
      paramObjectOutput.writeUTF((String)localObject);
      if (this.mSourceUrl != null) {
        break label715;
      }
      localObject = "";
      label283:
      paramObjectOutput.writeUTF((String)localObject);
      if (this.mSourceAction != null) {
        break label723;
      }
      localObject = "";
      label301:
      paramObjectOutput.writeUTF((String)localObject);
      if (this.mSourceActionData != null) {
        break label731;
      }
      localObject = "";
      label319:
      paramObjectOutput.writeUTF((String)localObject);
      if (this.mSource_A_ActionData != null) {
        break label739;
      }
      localObject = "";
      label337:
      paramObjectOutput.writeUTF((String)localObject);
      if (this.mSource_I_ActionData != null) {
        break label747;
      }
      localObject = "";
      label355:
      paramObjectOutput.writeUTF((String)localObject);
      paramObjectOutput.writeInt(this.fwFlag);
      paramObjectOutput.writeInt(this.mFlag);
      paramObjectOutput.writeBoolean(this.mHasSource);
      if (this.mCommentText != null) {
        break label755;
      }
      localObject = "";
      label403:
      paramObjectOutput.writeUTF((String)localObject);
      if (this.mCompatibleText != null) {
        break label763;
      }
      localObject = "";
      label421:
      paramObjectOutput.writeUTF((String)localObject);
      paramObjectOutput.writeLong(this.msgId);
      paramObjectOutput.writeInt(this.mPromotionType);
      if (this.mPromotionMsg != null) {
        break label771;
      }
      localObject = "";
      label459:
      paramObjectOutput.writeUTF((String)localObject);
      if (this.mPromotionMenus != null) {
        break label779;
      }
      localObject = "";
      label477:
      paramObjectOutput.writeUTF((String)localObject);
      paramObjectOutput.writeInt(this.mPromotionMenuDestructiveIndex);
      if (this.source_puin != null) {
        break label787;
      }
      localObject = "";
      label505:
      paramObjectOutput.writeUTF((String)localObject);
      paramObjectOutput.writeInt(this.adverSign);
      if (this.adverKey != null) {
        break label795;
      }
      localObject = "";
      label533:
      paramObjectOutput.writeUTF((String)localObject);
      if (this.index != null) {
        break label803;
      }
      localObject = "";
      label551:
      paramObjectOutput.writeUTF((String)localObject);
      if (this.index_name != null) {
        break label811;
      }
      localObject = "";
      label569:
      paramObjectOutput.writeUTF((String)localObject);
      if (this.index_type != null) {
        break label819;
      }
      localObject = "";
      label587:
      paramObjectOutput.writeUTF((String)localObject);
      paramObjectOutput.writeInt(this.thumbWidth);
      paramObjectOutput.writeInt(this.thumbHeight);
      paramObjectOutput.writeInt(this.mImageBizType);
      if (this.rawUrl != null) {
        break label827;
      }
      localObject = "";
      label635:
      paramObjectOutput.writeUTF((String)localObject);
      if (this.bigUrl != null) {
        break label835;
      }
      localObject = "";
      label653:
      paramObjectOutput.writeUTF((String)localObject);
      if (this.thumbUrl != null) {
        break label843;
      }
    }
    label707:
    label843:
    for (localObject = "";; localObject = this.thumbUrl)
    {
      paramObjectOutput.writeUTF((String)localObject);
      paramObjectOutput.writeInt(this.width);
      paramObjectOutput.writeInt(this.height);
      return;
      localObject = this.mSourceIcon;
      break;
      localObject = this.mSourceName;
      break label265;
      label715:
      localObject = this.mSourceUrl;
      break label283;
      label723:
      localObject = this.mSourceAction;
      break label301;
      label731:
      localObject = this.mSourceActionData;
      break label319;
      label739:
      localObject = this.mSource_A_ActionData;
      break label337;
      label747:
      localObject = this.mSource_I_ActionData;
      break label355;
      label755:
      localObject = this.mCommentText;
      break label403;
      label763:
      localObject = this.mCompatibleText;
      break label421;
      localObject = this.mPromotionMsg;
      break label459;
      localObject = this.mPromotionMenus;
      break label477;
      localObject = this.source_puin;
      break label505;
      localObject = this.adverKey;
      break label533;
      localObject = this.index;
      break label551;
      localObject = this.index_name;
      break label569;
      localObject = this.index_type;
      break label587;
      localObject = this.rawUrl;
      break label635;
      localObject = this.bigUrl;
      break label653;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.StructMsgForImageShare
 * JD-Core Version:    0.7.0.1
 */