import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.device.datadef.DeviceInfo;
import com.tencent.device.datadef.ProductInfo;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.activity.aio.photo.AIOImageData;
import com.tencent.mobileqq.activity.aio.photo.AIOImageProviderService;
import com.tencent.mobileqq.activity.selectmember.ResultRecord;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.filemanager.widget.AsyncImageView;
import com.tencent.mobileqq.troop.widget.EllipsizingTextView;
import com.tencent.mobileqq.widget.AnimationTextView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqprotect.qsec.QSecFramework;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class ahhq
  extends ahhm
{
  private static FileManagerEntity p;
  private static ChatMessage w;
  private boolean cgW;
  boolean cgX = false;
  protected boolean cgY;
  boolean cgZ = false;
  private ImageView zQ;
  
  public ahhq(Intent paramIntent)
  {
    super(paramIntent);
    this.cZS = 10;
  }
  
  private int EY()
  {
    Object localObject = a();
    if ((localObject == null) && (TextUtils.isEmpty(this.bKB))) {}
    while ((localObject == null) && (TextUtils.isEmpty(this.bKB))) {
      return -1;
    }
    if (localObject != null) {}
    String str;
    int i;
    for (localObject = ((ForwardFileInfo)localObject).getFileName();; localObject = this.bKB)
    {
      str = wr();
      i = ahav.getFileType((String)localObject);
      if ((i != 0) || (!aqhq.fileExistsAndNotEmpty(str))) {
        break;
      }
      return 2;
    }
    if ((i == 2) && (aqhq.fileExistsAndNotEmpty(str))) {
      return 3;
    }
    return 1;
  }
  
  private ForwardFileInfo a()
  {
    if (this.b != null) {
      return this.b;
    }
    if ((this.wU != null) && (this.wU.size() == 1)) {
      return (ForwardFileInfo)this.wU.get(0);
    }
    return null;
  }
  
  public static ForwardFileInfo a(FileManagerEntity paramFileManagerEntity)
  {
    return a(paramFileManagerEntity, null);
  }
  
  public static ForwardFileInfo a(FileManagerEntity paramFileManagerEntity, ChatMessage paramChatMessage)
  {
    p = paramFileManagerEntity;
    w = paramChatMessage;
    paramChatMessage = new ForwardFileInfo();
    paramChatMessage.setType(e(paramFileManagerEntity));
    paramChatMessage.Oj(paramFileManagerEntity.getCloudType());
    paramChatMessage.p(paramFileManagerEntity.nSessionId);
    paramChatMessage.jB(paramFileManagerEntity.uniseq);
    paramChatMessage.setFileName(paramFileManagerEntity.fileName);
    paramChatMessage.setFileSize(paramFileManagerEntity.fileSize);
    paramChatMessage.setLocalPath(paramFileManagerEntity.getFilePath());
    paramChatMessage.setFileId(paramFileManagerEntity.WeiYunFileId);
    if (!TextUtils.isEmpty(paramFileManagerEntity.strLargeThumPath)) {
      paramChatMessage.aA(paramFileManagerEntity.strLargeThumPath);
    }
    for (;;)
    {
      if (paramFileManagerEntity.Uuid != null) {
        paramChatMessage.setUuid(paramFileManagerEntity.Uuid);
      }
      if (paramFileManagerEntity.TroopUin != 0L) {
        paramChatMessage.jA(paramFileManagerEntity.TroopUin);
      }
      if (paramFileManagerEntity.strTroopFileID != null) {
        paramChatMessage.Ja(paramFileManagerEntity.strTroopFileID);
      }
      return paramChatMessage;
      if (!TextUtils.isEmpty(paramFileManagerEntity.strMiddleThumPath)) {
        paramChatMessage.aA(paramFileManagerEntity.strMiddleThumPath);
      } else {
        paramChatMessage.aA(paramFileManagerEntity.strThumbPath);
      }
    }
  }
  
  private boolean a(RecentUser paramRecentUser)
  {
    if (paramRecentUser.getType() == 9501) {}
    while (((paramRecentUser.getType() == 1006) && (!e(ahgg.a.Y))) || (paramRecentUser.getType() == 6004) || (paramRecentUser.getType() == 7000)) {
      return false;
    }
    return true;
  }
  
  private Drawable aK()
  {
    String str = wr();
    if (aqhq.fileExistsAndNotEmpty(str))
    {
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mLoadingDrawable = aoop.am();
      localURLDrawableOptions.mFailedDrawable = aoop.getFailedDrawable();
      return URLDrawable.getFileDrawable(str, localURLDrawableOptions);
    }
    return null;
  }
  
  private boolean b(RecentUser paramRecentUser)
  {
    if (((paramRecentUser.getType() == 1) && (!kj(paramRecentUser.uin))) || ((paramRecentUser.getType() == 0) && (!jqs.d(this.app, paramRecentUser.uin, paramRecentUser.getType()))) || (paramRecentUser.getType() == 3000) || (-1L != ahav.H(paramRecentUser.getType()))) {}
    while ((paramRecentUser.uin.equalsIgnoreCase(acbn.bkw)) && (e(ahgg.a.W)) && (anA())) {
      return true;
    }
    return false;
  }
  
  private boolean c(RecentUser paramRecentUser)
  {
    if (((paramRecentUser.getType() == 0) && (!jqs.d(this.app, paramRecentUser.uin, paramRecentUser.getType()))) || (paramRecentUser.getType() == 1) || (paramRecentUser.getType() == 3000) || (paramRecentUser.getType() == 1006) || (paramRecentUser.getType() == 1004) || (paramRecentUser.getType() == 1000)) {}
    while ((paramRecentUser.uin.equalsIgnoreCase(acbn.bkw)) && (e(ahgg.a.W)) && (anA())) {
      return true;
    }
    return false;
  }
  
  private boolean d(RecentUser paramRecentUser)
  {
    return paramRecentUser.getType() == 1;
  }
  
  private void doe()
  {
    String str = wq();
    if (aqhq.fileExistsAndNotEmpty(str))
    {
      File localFile = new File(str);
      this.bKC = localFile.getName();
      this.bKB = str;
      this.aaD = localFile.length();
    }
  }
  
  private void dof()
  {
    Object localObject1 = a();
    int i;
    if (localObject1 != null)
    {
      i = ((ForwardFileInfo)localObject1).getType();
      if (((i == 10000) || (i == 10006)) && (EY() == 2)) {
        fZ(wq(), String.valueOf(((ForwardFileInfo)localObject1).getFriendUin()));
      }
    }
    for (;;)
    {
      return;
      long l1;
      if ((i == 10000) || (i == 10001) || (i == 10002) || (i == 10004) || (i == 10003))
      {
        l1 = ((ForwardFileInfo)localObject1).fR();
        localObject1 = this.app.a().b(l1);
        if (localObject1 != null) {
          agzy.a((FileManagerEntity)localObject1).e(this.mActivity, i, 12);
        }
      }
      else if (i == 10006)
      {
        l1 = ((ForwardFileInfo)localObject1).fR();
        Object localObject2 = this.app.a().b(l1);
        if (localObject2 != null)
        {
          localObject2 = apsv.a(this.app, (FileManagerEntity)localObject2);
          l1 = ((ForwardFileInfo)localObject1).getFriendUin();
          long l2 = this.mIntent.getLongExtra("last_time", 0L);
          localObject1 = this.mIntent.getStringExtra("sender_uin");
          ahbr.a(this.app, this.mActivity, null, null, l1, (apcy)localObject2, (String)localObject1, l2, -1, 12, null, false, false);
          return;
          if (aqhq.fileExistsAndNotEmpty(this.bKB)) {
            try
            {
              localObject1 = ahav.a(new FileInfo(this.bKB));
              if (localObject1 != null)
              {
                agzy.a((FileManagerEntity)localObject1).q(this.mActivity, 12);
                return;
              }
            }
            catch (Exception localException)
            {
              localException.printStackTrace();
            }
          }
        }
      }
    }
  }
  
  public static int e(FileManagerEntity paramFileManagerEntity)
  {
    if (paramFileManagerEntity != null) {}
    switch (paramFileManagerEntity.getCloudType())
    {
    case 4: 
    default: 
      if (QLog.isColorLevel()) {
        QLog.e("dataline", 2, "FileManagerEntity->cloudType 转 ForwardFileInfo->type， 未识别的cloudType[" + paramFileManagerEntity.getCloudType());
      }
    case 3: 
    case 5: 
    case 6: 
    case 7: 
      do
      {
        return 10000;
      } while (ahbj.fileExistsAndNotEmpty(paramFileManagerEntity.getFilePath()));
      return 10009;
    case 1: 
      return 10002;
    case 2: 
      return 10003;
    }
    return 10011;
  }
  
  private boolean e(RecentUser paramRecentUser)
  {
    if (!aqft.ri(paramRecentUser.uin))
    {
      if (((paramRecentUser.getType() != 0) || (jqs.d(this.app, paramRecentUser.uin, paramRecentUser.getType()))) && ((paramRecentUser.getType() != 1) || (!e(T)) || (kj(paramRecentUser.uin))) && (paramRecentUser.getType() != 3000) && (ahav.H(paramRecentUser.getType()) == -1L)) {}
    }
    else {
      while ((paramRecentUser.uin.equalsIgnoreCase(acbn.bkw)) && (e(ahgg.a.W)) && (anA())) {
        return true;
      }
    }
    return false;
  }
  
  private void fZ(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ForwardOption.ForwardFileOption", 2, "startToGalleryWithPath: path=" + paramString1);
    }
    if (!TextUtils.isEmpty(paramString1))
    {
      AIOImageData localAIOImageData = new AIOImageData();
      localAIOImageData.aVW = paramString1;
      localAIOImageData.aVX = paramString1;
      localAIOImageData.aVY = paramString1;
      localAIOImageData.bjd = false;
      paramString1 = new Bundle();
      paramString1.putBoolean("extra.EXTRA_NOT_CLEAR_TOP", true);
      paramString1.putBoolean("key_allow_forward_photo_preview_edit", true);
      a(paramString1, new AIOImageProviderService(this.app.getCurrentUin(), paramString2, 0, null), localAIOImageData);
      dnZ();
    }
  }
  
  private boolean jS(int paramInt)
  {
    return (paramInt == 2) || (paramInt == 3) || (paramInt == 0) || (paramInt == 7) || (paramInt == 6) || (paramInt == 10) || (paramInt == 9);
  }
  
  private String lm(String paramString)
  {
    String str = acbn.SDCARD_PATH + "photo/" + String.valueOf(System.currentTimeMillis()) + ".jpg";
    try
    {
      aqhu.b(this.app.getApplication(), paramString, str, 600, 800);
      return str;
    }
    catch (Exception paramString) {}
    return str;
  }
  
  private String wq()
  {
    Object localObject2;
    Object localObject1;
    if (this.b == null)
    {
      localObject2 = this.mIntent.getStringExtra("forward_filepath");
      localObject1 = localObject2;
      if (TextUtils.isEmpty((CharSequence)localObject2)) {
        localObject1 = this.bf.getString("forward_filepath");
      }
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        break label77;
      }
      localObject2 = null;
    }
    label77:
    int i;
    do
    {
      return localObject2;
      localObject2 = this.b.getLocalPath();
      localObject1 = localObject2;
      if (!TextUtils.isEmpty((CharSequence)localObject2)) {
        break;
      }
      localObject1 = this.b.getThumbPath();
      break;
      i = ahav.getFileType((String)localObject1);
      if (i == -1) {
        break label95;
      }
      localObject2 = localObject1;
    } while (i != 11);
    label95:
    return lm((String)localObject1);
  }
  
  private String wr()
  {
    Object localObject = a();
    if (localObject != null) {
      localObject = ((ForwardFileInfo)localObject).getThumbPath();
    }
    String str;
    do
    {
      return localObject;
      str = this.mIntent.getStringExtra("forward_thumb");
      localObject = str;
    } while (!TextUtils.isEmpty(str));
    return this.bf.getString("forward_thumb");
  }
  
  protected String B()
  {
    return this.mAppContext.getString(2131720159);
  }
  
  protected int EW()
  {
    int i;
    if (p != null)
    {
      if (!new aviz(3).a(this.app, this.mActivity, p, w, true)) {
        break label131;
      }
      p = null;
      i = 0;
    }
    for (;;)
    {
      if (i == 0) {
        avjg.a(this.app, "User_AddFav", -1, 0, 69, 0, "", "");
      }
      return i;
      if (this.b != null)
      {
        FileManagerEntity localFileManagerEntity = this.app.a().b(this.b.fR());
        if ((localFileManagerEntity != null) && (new aviz(3).a(this.app, this.mActivity, localFileManagerEntity, null, true)))
        {
          p = null;
          i = 0;
          continue;
        }
      }
      label131:
      i = -1;
    }
  }
  
  public void H(int paramInt, Bundle paramBundle)
  {
    if ((this.cgY) && (!this.cgX) && (-1L != ahav.H(paramBundle.getInt("uintype"))))
    {
      aqha.a(this.mActivity, 230, this.mActivity.getString(2131699881), this.mActivity.getString(2131699834), null, this.mActivity.getString(2131721303), new ahhr(this), null).show();
      return;
    }
    super.H(paramInt, paramBundle);
  }
  
  public DeviceInfo[] a(DeviceInfo[] paramArrayOfDeviceInfo)
  {
    ArrayList localArrayList = new ArrayList();
    syw localsyw = (syw)this.app.getBusinessHandler(51);
    int j = paramArrayOfDeviceInfo.length;
    int i = 0;
    if (i < j)
    {
      DeviceInfo localDeviceInfo = paramArrayOfDeviceInfo[i];
      ProductInfo localProductInfo;
      if (localDeviceInfo != null)
      {
        int k = ahav.getFileType(wq());
        localProductInfo = localsyw.a(localDeviceInfo.productId);
        if ((k != 2) || (!localsyw.bn(localDeviceInfo.din)) || (!localsyw.i(localDeviceInfo.din, 17))) {
          break label105;
        }
      }
      for (;;)
      {
        i += 1;
        break;
        label105:
        if ((localProductInfo != null) && (localProductInfo.isSupportMainMsgType(8)) && (e(aa))) {
          localArrayList.add(localDeviceInfo);
        }
      }
    }
    return (DeviceInfo[])localArrayList.toArray(new DeviceInfo[localArrayList.size()]);
  }
  
  public List<RecentUser> aD(List<RecentUser> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    if (this.mIntent.getIntExtra("forward_source_uin_type", 0) == 9501) {
      return localArrayList;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      RecentUser localRecentUser = (RecentUser)paramList.next();
      if ((localRecentUser != null) && (a(localRecentUser)) && (localRecentUser.getType() != 8001)) {
        if ((this.cgY) && (b(localRecentUser))) {
          localArrayList.add(localRecentUser);
        } else if ((this.cgW) && (c(localRecentUser))) {
          localArrayList.add(localRecentUser);
        } else if ((this.cgZ) && (d(localRecentUser))) {
          localArrayList.add(localRecentUser);
        } else if (e(localRecentUser)) {
          localArrayList.add(localRecentUser);
        }
      }
    }
    return localArrayList;
  }
  
  public boolean anj()
  {
    boolean bool2 = false;
    super.anj();
    this.cgR = this.mIntent.getBooleanExtra("forward _key_nojump", false);
    Object localObject;
    int i;
    boolean bool1;
    if (this.b != null)
    {
      int j = this.b.Ev();
      localObject = this.b.getLocalPath();
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        i = 1;
        if (this.b.getType() != 10006) {
          break label187;
        }
        bool1 = true;
        label72:
        this.cgY = bool1;
        if (this.b.getType() != 10009) {
          break label192;
        }
        bool1 = true;
        label92:
        this.cgZ = bool1;
        if (j != 2) {
          break label197;
        }
        bool1 = true;
        label104:
        this.cgW = bool1;
        bool1 = bool2;
        if (i != 0) {
          if (j != 3)
          {
            bool1 = bool2;
            if (!aqhq.fileExists((String)localObject)) {}
          }
          else
          {
            bool1 = true;
          }
        }
        this.cgX = bool1;
        label138:
        break label223;
      }
    }
    for (;;)
    {
      this.bf.putString("leftBackText", this.mActivity.getString(2131720735));
      if ((this.b == null) && (TextUtils.isEmpty(this.bKB))) {
        doe();
      }
      return true;
      i = 0;
      break;
      label187:
      bool1 = false;
      break label72;
      label192:
      bool1 = false;
      break label92;
      label197:
      bool1 = false;
      break label104;
      if (this.wU != null)
      {
        this.cgZ = true;
        localObject = this.wU.iterator();
        label223:
        if (!((Iterator)localObject).hasNext()) {
          continue;
        }
        ForwardFileInfo localForwardFileInfo = (ForwardFileInfo)((Iterator)localObject).next();
        if ((localForwardFileInfo == null) || (localForwardFileInfo.Ev() == 6)) {
          break label138;
        }
        this.cgZ = false;
        continue;
      }
      if (this.mIntent.getBooleanExtra("isFromShare", false)) {
        this.cgX = true;
      }
    }
  }
  
  protected boolean anl()
  {
    boolean bool = this.mIntent.getBooleanExtra("isFromShare", false);
    Intent localIntent;
    if (anq())
    {
      localObject = fg();
      localIntent = wja.a(new Intent(this.mActivity, SplashActivity.class), null);
      if (QLog.isColorLevel()) {
        QLog.d("forward", 2, "fileoption realForwardTo isfromshare=" + bool);
      }
      if (bool)
      {
        this.bf.putString("leftBackText", acfp.m(2131706459));
        localIntent.addFlags(268435456);
        localIntent.addFlags(67108864);
        localIntent.putExtras(this.bf);
        bool = aa(localIntent);
        if (this.cgS)
        {
          ForwardUtils.a(this.app, this.mActivity, this.mAppContext, localIntent, null);
          if ((QSecFramework.a().c(1003).booleanValue()) && (this.cgX))
          {
            localObject = ((List)localObject).iterator();
            while (((Iterator)localObject).hasNext())
            {
              ResultRecord localResultRecord = (ResultRecord)((Iterator)localObject).next();
              arnv.a().n(4, wq(), localResultRecord.lk(), localResultRecord.uin);
              arnv.a().report();
            }
          }
        }
        else if (!bool)
        {
          ForwardUtils.a(this.app, this.mActivity, this.mAppContext, localIntent, null);
        }
      }
      for (;;)
      {
        localIntent.putExtras(this.bf);
        this.mActivity.setResult(-1, localIntent);
        return false;
        if (!this.cgR)
        {
          localIntent.putExtras(this.bf);
          ForwardUtils.a(this.app, this.mActivity, this.mAppContext, localIntent, null);
        }
      }
    }
    int i = this.bf.getInt("uintype");
    Object localObject = this.bf.getString("uin");
    if (i == 1008)
    {
      localIntent = new Intent(this.mActivity, ChatActivity.class);
      localIntent.putExtra("chat_subType", kaw.a((String)localObject, this.app));
      if (QLog.isColorLevel()) {
        QLog.d("forward", 2, "fileoption realForwardTo isfromshare=" + bool);
      }
      if (!bool) {
        break label592;
      }
      this.bf.putString("leftBackText", acfp.m(2131706458));
      localIntent.addFlags(268435456);
      localIntent.addFlags(67108864);
      localIntent.putExtras(this.bf);
      bool = aa(localIntent);
      if (!this.cgS) {
        break label567;
      }
      this.mActivity.startActivity(localIntent);
      if ((QSecFramework.a().c(1003).booleanValue()) && (this.cgX))
      {
        arnv.a().n(4, wq(), i, (String)localObject);
        arnv.a().report();
      }
    }
    for (;;)
    {
      localIntent.putExtras(this.bf);
      this.mActivity.setResult(-1, localIntent);
      this.mActivity.finish();
      return false;
      localIntent = wja.a(new Intent(this.mActivity, SplashActivity.class), null);
      break;
      label567:
      if (!bool)
      {
        ForwardUtils.a(this.app, this.mActivity, this.mAppContext, localIntent, null);
        continue;
        label592:
        if (!this.cgR)
        {
          localIntent.putExtras(this.bf);
          ForwardUtils.a(this.app, this.mActivity, this.mAppContext, localIntent, null);
        }
      }
    }
  }
  
  public boolean ann()
  {
    return true;
  }
  
  protected boolean ans()
  {
    return true;
  }
  
  protected View cc()
  {
    Object localObject2 = a();
    int i = wja.dp2px(8.0F, this.mActivity.getResources());
    int j = wja.dp2px(12.0F, this.mActivity.getResources());
    int k = wja.dp2px(15.0F, this.mActivity.getResources());
    int m = wja.dp2px(16.0F, this.mActivity.getResources());
    int n = wja.dp2px(20.0F, this.mActivity.getResources());
    int i1 = wja.dp2px(32.0F, this.mActivity.getResources());
    int i2 = wja.dp2px(40.0F, this.mActivity.getResources());
    RelativeLayout localRelativeLayout = new RelativeLayout(this.mActivity);
    Object localObject1 = new RelativeLayout.LayoutParams(-2, -2);
    localRelativeLayout.setOnClickListener(new ahhs(this));
    localRelativeLayout.setOnTouchListener(new ahht(this));
    localRelativeLayout.setLayoutParams((ViewGroup.LayoutParams)localObject1);
    int i3 = EY();
    Object localObject3;
    if (i3 == 2)
    {
      localRelativeLayout.setPadding(0, k, 0, k);
      localObject1 = new URLImageView(this.mActivity);
      ((URLImageView)localObject1).setId(2131367533);
      ((URLImageView)localObject1).setAdjustViewBounds(true);
      ((URLImageView)localObject1).setMaxHeight(aqnm.dip2px(140.0F));
      ((URLImageView)localObject1).setScaleType(ImageView.ScaleType.CENTER_CROP);
      localObject2 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject2).addRule(13);
      localRelativeLayout.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
      this.zQ = ((ImageView)localObject1);
      localObject2 = new View(this.mActivity);
      ((View)localObject2).setId(2131367528);
      ((View)localObject2).setBackgroundColor(Color.argb(0, 0, 0, 0));
      localObject3 = new RelativeLayout.LayoutParams(-1, -1);
      ((RelativeLayout.LayoutParams)localObject3).addRule(6, 2131367533);
      ((RelativeLayout.LayoutParams)localObject3).addRule(8, 2131367533);
      ((RelativeLayout.LayoutParams)localObject3).addRule(5, 2131367533);
      ((RelativeLayout.LayoutParams)localObject3).addRule(7, 2131367533);
      localRelativeLayout.addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
      localObject2 = aK();
      if (localObject2 != null) {
        ((URLImageView)localObject1).setImageDrawable((Drawable)localObject2);
      }
      return localRelativeLayout;
    }
    if (i3 == 3)
    {
      localRelativeLayout.setPadding(0, k, 0, k);
      localObject1 = new URLImageView(this.mActivity);
      ((URLImageView)localObject1).setId(2131367533);
      ((URLImageView)localObject1).setAdjustViewBounds(true);
      ((URLImageView)localObject1).setMaxHeight(aqnm.dip2px(140.0F));
      ((URLImageView)localObject1).setScaleType(ImageView.ScaleType.CENTER_CROP);
      localObject2 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject2).addRule(13);
      localRelativeLayout.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
      localObject2 = new View(this.mActivity);
      ((View)localObject2).setId(2131367528);
      ((View)localObject2).setBackgroundColor(Color.argb(0, 0, 0, 0));
      localObject3 = new RelativeLayout.LayoutParams(-1, -1);
      ((RelativeLayout.LayoutParams)localObject3).addRule(6, 2131367533);
      ((RelativeLayout.LayoutParams)localObject3).addRule(8, 2131367533);
      ((RelativeLayout.LayoutParams)localObject3).addRule(5, 2131367533);
      ((RelativeLayout.LayoutParams)localObject3).addRule(7, 2131367533);
      localRelativeLayout.addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
      localObject2 = new ImageView(this.mActivity);
      ((ImageView)localObject2).setId(2131367534);
      localObject3 = new RelativeLayout.LayoutParams(i2, i2);
      ((RelativeLayout.LayoutParams)localObject3).addRule(13);
      localRelativeLayout.addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
      localObject3 = aK();
      if (localObject3 != null) {
        ((URLImageView)localObject1).setImageDrawable((Drawable)localObject3);
      }
      ((ImageView)localObject2).setImageResource(2130840500);
      return localRelativeLayout;
    }
    if (i3 == 1)
    {
      localRelativeLayout.setPadding(0, n, 0, n);
      localObject1 = new ImageView(this.mActivity);
      ((ImageView)localObject1).setId(2131367527);
      ((ImageView)localObject1).setImageResource(2130840498);
      localObject3 = new RelativeLayout.LayoutParams(j, m);
      ((RelativeLayout.LayoutParams)localObject3).addRule(11);
      ((RelativeLayout.LayoutParams)localObject3).addRule(15);
      ((RelativeLayout.LayoutParams)localObject3).leftMargin = i;
      localRelativeLayout.addView((View)localObject1, (ViewGroup.LayoutParams)localObject3);
      localObject3 = new AsyncImageView(this.mActivity);
      ((AsyncImageView)localObject3).setId(2131367529);
      localObject1 = new RelativeLayout.LayoutParams(i1, i1);
      ((RelativeLayout.LayoutParams)localObject1).addRule(15);
      ((RelativeLayout.LayoutParams)localObject1).addRule(0, 2131367527);
      localRelativeLayout.addView((View)localObject3, (ViewGroup.LayoutParams)localObject1);
      localObject1 = new LinearLayout(this.mActivity);
      ((LinearLayout)localObject1).setId(2131367532);
      ((LinearLayout)localObject1).setOrientation(1);
      ((LinearLayout)localObject1).setBackgroundColor(Color.argb(0, 0, 0, 0));
      Object localObject4 = new RelativeLayout.LayoutParams(-1, -2);
      ((RelativeLayout.LayoutParams)localObject4).addRule(0, 2131367529);
      ((RelativeLayout.LayoutParams)localObject4).addRule(9);
      localRelativeLayout.addView((View)localObject1, (ViewGroup.LayoutParams)localObject4);
      localObject4 = new EllipsizingTextView(this.mActivity, null);
      ((TextView)localObject4).setId(2131367530);
      ((TextView)localObject4).setMaxLines(1);
      ((TextView)localObject4).setIncludeFontPadding(false);
      ((TextView)localObject4).setLineSpacing(0.0F, 1.0F);
      ((TextView)localObject4).setEllipsize(TextUtils.TruncateAt.MIDDLE);
      ((TextView)localObject4).setTextColor(Color.parseColor("#777777"));
      ((TextView)localObject4).setTextSize(1, 14.0F);
      ((LinearLayout)localObject1).addView((View)localObject4);
      TextView localTextView = new TextView(this.mActivity);
      localTextView.setId(2131367531);
      localTextView.setSingleLine();
      localTextView.setGravity(3);
      localTextView.setTextColor(Color.parseColor("#777777"));
      localTextView.setTextSize(1, 14.0F);
      ((LinearLayout)localObject1).addView(localTextView);
      localObject1 = new LinearLayout(this.mActivity);
      ((LinearLayout)localObject1).setId(2131367528);
      ((LinearLayout)localObject1).setOrientation(1);
      ((LinearLayout)localObject1).setBackgroundColor(Color.argb(0, 0, 0, 0));
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
      localLayoutParams.addRule(6, 2131367532);
      localLayoutParams.addRule(8, 2131367532);
      localRelativeLayout.addView((View)localObject1, localLayoutParams);
      if (localObject2 != null)
      {
        localObject1 = ((ForwardFileInfo)localObject2).getFileName();
        if (localObject2 == null) {
          break label1152;
        }
      }
      label1152:
      for (long l = ((ForwardFileInfo)localObject2).getFileSize();; l = this.aaD)
      {
        ahav.b((AsyncImageView)localObject3, (String)localObject1);
        ((TextView)localObject4).setText((CharSequence)localObject1);
        localTextView.setText(ahbj.j(l, this.mActivity.getResources().getDisplayMetrics().densityDpi));
        return localRelativeLayout;
        localObject1 = this.bKC;
        break;
      }
    }
    localRelativeLayout.setPadding(0, n, 0, n);
    localObject1 = new AnimationTextView(this.mActivity);
    ((AnimationTextView)localObject1).setText(wn());
    ((AnimationTextView)localObject1).setMaxLines(3);
    ((AnimationTextView)localObject1).setEllipsize(TextUtils.TruncateAt.END);
    ((AnimationTextView)localObject1).setTextColor(this.mActivity.getResources().getColorStateList(2131165857));
    ((AnimationTextView)localObject1).setTextSize(14.0F);
    localObject2 = new RelativeLayout.LayoutParams(-1, -2);
    ((RelativeLayout.LayoutParams)localObject2).bottomMargin = ankt.dip2px(10.0F);
    localRelativeLayout.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
    localRelativeLayout.setOnClickListener(null);
    localRelativeLayout.setOnTouchListener(null);
    return localRelativeLayout;
  }
  
  protected void dnU()
  {
    String str1 = wq();
    String str2;
    int i;
    Object localObject;
    if (!TextUtils.isEmpty(str1))
    {
      str2 = this.bf.getString("uin");
      i = ahav.getFileType(str1);
      if (i != 2) {
        break label92;
      }
      localObject = szy.aIj;
    }
    for (;;)
    {
      szy localszy = (szy)this.app.getBusinessHandler(49);
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(str1);
      localszy.a().a((String)localObject, str2, localArrayList, null);
      this.mActivity.finish();
      return;
      label92:
      localObject = (syw)this.app.getBusinessHandler(51);
      if ((localObject != null) && (((syw)localObject).i(Long.parseLong(this.bf.getString("uin")), 17)))
      {
        ((syw)localObject).a(Long.parseLong(str2), "", "", "", 0, null);
        if (i == 0)
        {
          super.aG(str1, str2, "pic");
          return;
        }
        super.aG(str1, str2, "file");
        return;
      }
      if (i == 0) {
        localObject = szy.aIl;
      } else {
        localObject = szy.aIj;
      }
    }
  }
  
  protected void dnr()
  {
    if ((!this.cgZ) && (anx()))
    {
      this.cs.add(S);
      this.cs.add(Z);
    }
    if ((!this.cgZ) && (anv())) {
      this.cs.add(U);
    }
    if (((this.b == null) || (this.b.getType() == 10006) || (this.b.getType() == 10003) || (this.b.getType() == 10002) || (this.b.getType() != 10009)) || (anw())) {
      this.cs.add(T);
    }
    if (this.b != null) {
      if (acde.c(this.app.a().b(this.b.fR())))
      {
        this.cs.add(W);
        this.cs.add(ab);
        break label307;
      }
    }
    for (;;)
    {
      if ((this.mIntent != null) && (this.mIntent.getBooleanExtra("isFromFavorites", false))) {
        this.cs.add(W);
      }
      if ((this.mIntent != null) && (this.mIntent.getBooleanExtra("k_smartdevice", true)) && (anz()) && (jS(ahav.getFileType(wq())))) {
        this.cs.add(aa);
      }
      return;
      if (this.wU != null)
      {
        Iterator localIterator = this.wU.iterator();
        label307:
        if (!localIterator.hasNext()) {
          continue;
        }
        ForwardFileInfo localForwardFileInfo = (ForwardFileInfo)localIterator.next();
        if ((localForwardFileInfo == null) || (!acde.c(this.app.a().b(localForwardFileInfo.fR())))) {
          break;
        }
        this.cs.add(W);
        this.cs.add(ab);
        continue;
      }
      this.cs.add(W);
      this.cs.add(ab);
    }
  }
  
  protected void dt(Intent paramIntent)
  {
    ArrayList localArrayList2 = null;
    ArrayList localArrayList1 = this.bf.getParcelableArrayList("fileinfo_array");
    if (localArrayList1 != null) {}
    for (;;)
    {
      try
      {
        localArrayList1 = (ArrayList)localArrayList1;
        ArrayList localArrayList3 = (ArrayList)this.bf.get("android.intent.extra.STREAM");
        if (localArrayList1 == null)
        {
          localArrayList2 = new ArrayList();
          int i = 0;
          if (i < localArrayList3.size())
          {
            Uri localUri = (Uri)localArrayList3.get(i);
            localArrayList2.add(b(this.mActivity, localUri));
            i += 1;
            continue;
          }
        }
      }
      catch (ClassCastException localClassCastException)
      {
        localObject = null;
        continue;
        paramIntent.putExtra("dataline_forward_type", 100);
        paramIntent.putExtra("sendMultiple", true);
        if (localObject == null) {
          paramIntent.putStringArrayListExtra("dataline_forward_pathlist", localArrayList2);
        }
        return;
      }
      Object localObject = null;
    }
  }
  
  protected void du(Intent paramIntent)
  {
    paramIntent.putExtra("dataline_forward_type", 100);
    if (this.b == null)
    {
      String str2 = this.mIntent.getStringExtra("forward_filepath");
      String str1 = str2;
      if (str2 == null) {
        str1 = this.bf.getString("forward_filepath");
      }
      paramIntent.putExtra("dataline_forward_path", str1);
    }
    for (;;)
    {
      if ((this.mIntent != null) && (this.mIntent.getBooleanExtra("isFromFavorites", false)) && (this.mIntent.getBooleanExtra("isJumpAIO", false))) {
        this.mIntent.putExtra("hasJumpAIO", true);
      }
      return;
      paramIntent.putExtra("dataline_forward_path", this.b.getLocalPath());
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt1 == 19001) && (paramInt2 == -1))
    {
      paramIntent = paramIntent.getStringExtra("PhotoConst.SINGLE_PHOTO_PATH");
      Object localObject = wq();
      if (QLog.isColorLevel()) {
        QLog.d("ForwardOption.ForwardFileOption", 2, "refresh forward preview,editPicPath:" + paramIntent + " :currentFile" + (String)localObject);
      }
      if (!((String)localObject).equals(paramIntent))
      {
        this.cgO = false;
        this.bf.remove("FORWARD_MSG_FOR_PIC");
        this.bf.putString("forward_filepath", paramIntent);
        this.bf.putString("forward_extra", paramIntent);
        this.bf.putBoolean("extra_is_edited_pic", true);
        localObject = a();
        if (localObject != null)
        {
          ((ForwardFileInfo)localObject).setLocalPath(paramIntent);
          ((ForwardFileInfo)localObject).aA(paramIntent);
        }
        paramIntent = aK();
        if (paramIntent != null) {
          this.zQ.setImageDrawable(paramIntent);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahhq
 * JD-Core Version:    0.7.0.1
 */