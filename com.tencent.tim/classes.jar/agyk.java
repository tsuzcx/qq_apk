import android.app.Activity;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.activity.ForwardRecentTranslucentActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.weiyun.transmission.upload.UploadFile;
import com.tencent.weiyun.transmission.upload.UploadJobContext;
import com.tencent.weiyun.transmission.upload.UploadJobContext.StatusInfo;
import com.tencent.weiyun.transmission.upload.UploadManager.IUploadStatusListener;
import java.util.ArrayList;
import java.util.List;
import mqq.os.MqqHandler;
import mqq.util.WeakReference;

public final class agyk
  implements DialogInterface.OnClickListener, Handler.Callback, View.OnClickListener
{
  private final View Dg;
  private final View Dh;
  private final View Di;
  private final MqqHandler H;
  private final TextView SZ;
  private final TextView Ta;
  private final TextView Tb;
  private final agyi a;
  private aqju ao;
  private volatile agmv b;
  private final boolean cfT;
  private final TextView fb;
  private volatile boolean mIsProcessing;
  private volatile String mShareUrl;
  private volatile FileManagerEntity n;
  private final MqqHandler q;
  private final MqqHandler t;
  private final View tt;
  private volatile boolean uU;
  
  public agyk(agyi paramagyi, View paramView, boolean paramBoolean)
  {
    this.a = paramagyi;
    this.cfT = paramBoolean;
    this.Dg = paramView.findViewById(2131373624);
    this.fb = ((TextView)paramView.findViewById(2131373623));
    this.Dh = paramView.findViewById(2131373617);
    this.Di = paramView.findViewById(2131373619);
    this.SZ = ((TextView)paramView.findViewById(2131373618));
    this.Ta = ((TextView)paramView.findViewById(2131373620));
    paramView.findViewById(2131373621).setOnClickListener(this);
    this.tt = paramView.findViewById(2131370512);
    this.Tb = ((TextView)paramView.findViewById(2131370525));
    paramView.findViewById(2131370514).setOnClickListener(this);
    paramView.findViewById(2131370523).setOnClickListener(this);
    this.q = new aurf(Looper.getMainLooper(), this, true);
    this.H = new aurf(ThreadManagerV2.getFileThreadLooper(), this, false);
    this.t = new aurf(ThreadManagerV2.getSubThreadLooper(), this, false);
    reset();
  }
  
  private void JC(String paramString)
  {
    Object localObject = this.n;
    if (localObject != null)
    {
      b((FileManagerEntity)localObject, null);
      return;
    }
    localObject = this.a.e().getAppInterface();
    if ((localObject instanceof QQAppInterface))
    {
      Message localMessage = new Message();
      localMessage.what = 8;
      localMessage.obj = new Object[] { (QQAppInterface)localObject, paramString };
      this.H.sendMessage(localMessage);
      return;
    }
    throw new IllegalStateException("processLocalFile: need QQAppInterface, must run in main process.");
  }
  
  private void N(float paramFloat)
  {
    int i = (int)Math.floor(100.0F * paramFloat);
    this.Ta.setText(i + "%");
    this.Ta.setVisibility(0);
  }
  
  private void Q(String paramString1, int paramInt, String paramString2)
  {
    this.mShareUrl = paramString1;
    if (this.cfT)
    {
      Message localMessage = new Message();
      localMessage.what = 10;
      localMessage.obj = new Object[] { paramString1, Integer.valueOf(paramInt), paramString2 };
      this.t.sendMessage(localMessage);
    }
    boolean bool;
    do
    {
      return;
      this.fb.setText(2131700318);
      this.Dh.setVisibility(8);
      this.tt.setVisibility(0);
      this.Tb.setText(paramString1);
      this.Tb.setTag(paramString2);
      bool = this.mIsProcessing;
      this.mIsProcessing = false;
    } while (!bool);
    this.a.dkG();
  }
  
  private void a(Bitmap paramBitmap, int paramInt, String paramString)
  {
    if (paramBitmap == null) {
      onError(-1, null);
    }
    for (;;)
    {
      reset();
      return;
      this.a.a(paramBitmap, paramInt, paramString);
      if (!paramBitmap.isRecycled()) {
        paramBitmap.recycle();
      }
    }
  }
  
  private void aa(Object[] paramArrayOfObject)
  {
    if ((paramArrayOfObject == null) || (paramArrayOfObject.length < 2)) {
      throw new IllegalArgumentException("handleError: args are invalid");
    }
    onError(((Integer)paramArrayOfObject[0]).intValue(), (String)paramArrayOfObject[1]);
  }
  
  private void ab(Object[] paramArrayOfObject)
  {
    if ((paramArrayOfObject == null) || (paramArrayOfObject.length < 2)) {
      throw new IllegalArgumentException("handleUpload: args are invalid");
    }
    QQAppInterface localQQAppInterface = (QQAppInterface)paramArrayOfObject[0];
    paramArrayOfObject = (String)paramArrayOfObject[1];
    int i;
    if (aqiw.isNetSupport(BaseApplicationImpl.sApplication))
    {
      paramArrayOfObject = localQQAppInterface.a().a().a(paramArrayOfObject, null, new agyk.b(this, paramArrayOfObject, null));
      if (paramArrayOfObject == null) {
        i = -3;
      }
    }
    for (;;)
    {
      if (i != 0)
      {
        paramArrayOfObject = new Message();
        paramArrayOfObject.what = 1;
        paramArrayOfObject.obj = new Object[] { Integer.valueOf(i), null };
        this.q.sendMessage(paramArrayOfObject);
      }
      return;
      this.b = paramArrayOfObject;
      i = 0;
      continue;
      i = 2;
    }
  }
  
  private void ac(Object[] paramArrayOfObject)
  {
    if ((paramArrayOfObject == null) || (paramArrayOfObject.length < 2)) {
      throw new IllegalArgumentException("handleUploadSucceed: args are invalid");
    }
    UploadJobContext.StatusInfo localStatusInfo = (UploadJobContext.StatusInfo)paramArrayOfObject[0];
    paramArrayOfObject = (String)paramArrayOfObject[1];
    if (QLog.isColorLevel()) {
      QLog.i("WeiyunShareProcessController<FileAssistant>", 2, "upload is succeed, for file:" + paramArrayOfObject);
    }
    N(1.0F);
    this.b = null;
    FileManagerEntity localFileManagerEntity = new FileManagerEntity();
    localFileManagerEntity.setCloudType(2);
    localFileManagerEntity.WeiYunFileId = localStatusInfo.fileId;
    if (localStatusInfo.jobContext != null) {}
    for (paramArrayOfObject = localStatusInfo.jobContext.file().pDirKey;; paramArrayOfObject = null)
    {
      localFileManagerEntity.WeiYunDirKey = paramArrayOfObject;
      this.n = localFileManagerEntity;
      b(localFileManagerEntity, null);
      return;
    }
  }
  
  private void ad(Object[] paramArrayOfObject)
  {
    if ((paramArrayOfObject == null) || (paramArrayOfObject.length < 1)) {
      throw new IllegalArgumentException("handleUploadProgress: args are invalid");
    }
    N(((Float)paramArrayOfObject[0]).floatValue());
  }
  
  private void ae(Object[] paramArrayOfObject)
  {
    if ((paramArrayOfObject == null) || (paramArrayOfObject.length < 5)) {
      throw new IllegalArgumentException("handleRequest: args are invalid");
    }
    Object localObject1 = (QQAppInterface)paramArrayOfObject[0];
    FileManagerEntity localFileManagerEntity = (FileManagerEntity)paramArrayOfObject[1];
    Object localObject2 = (agyi.a)paramArrayOfObject[2];
    boolean bool1 = ((Boolean)paramArrayOfObject[3]).booleanValue();
    paramArrayOfObject = (String)paramArrayOfObject[4];
    if (aqiw.isNetSupport(BaseApplicationImpl.sApplication))
    {
      long l = agyj.G(((agyi.a)localObject2).cYT);
      if (ahbj.fileExistsAndNotEmpty(paramArrayOfObject))
      {
        agmf localagmf = ((QQAppInterface)localObject1).a().a();
        if (!((agyi.a)localObject2).cfR) {
          break label222;
        }
        localObject1 = ((agyi.a)localObject2).aRN;
        label113:
        boolean bool2 = ((agyi.a)localObject2).cfS;
        i = ((agyi.a)localObject2).cYT;
        if (!((agyi.a)localObject2).cfR) {
          break label228;
        }
        localObject2 = ((agyi.a)localObject2).aRN;
        label141:
        localagmf.a(localFileManagerEntity, l, (String)localObject1, bool2, bool1, new agyk.a(this, i, (String)localObject2, paramArrayOfObject, bool1, null));
      }
    }
    for (int i = 0;; i = 2)
    {
      if (i != 0)
      {
        paramArrayOfObject = new Message();
        paramArrayOfObject.what = 1;
        paramArrayOfObject.obj = new Object[] { Integer.valueOf(i), null };
        this.q.sendMessage(paramArrayOfObject);
      }
      return;
      paramArrayOfObject = null;
      break;
      label222:
      localObject1 = null;
      break label113;
      label228:
      localObject2 = null;
      break label141;
    }
  }
  
  private void af(Object[] paramArrayOfObject)
  {
    if ((paramArrayOfObject == null) || (paramArrayOfObject.length < 3)) {
      throw new IllegalArgumentException("handleRequestSucceed: args are invalid");
    }
    Q((String)paramArrayOfObject[0], ((Integer)paramArrayOfObject[1]).intValue(), (String)paramArrayOfObject[2]);
  }
  
  private void ag(Object[] paramArrayOfObject)
  {
    if ((paramArrayOfObject == null) || (paramArrayOfObject.length < 3)) {
      throw new IllegalArgumentException("handleGetQr: args are invalid");
    }
    Object localObject = (String)paramArrayOfObject[0];
    int i = ((Integer)paramArrayOfObject[1]).intValue();
    String str = (String)paramArrayOfObject[2];
    try
    {
      paramArrayOfObject = agyj.i((String)localObject, aqnm.dip2px(184.0F));
      localObject = new Message();
      ((Message)localObject).what = 7;
      ((Message)localObject).obj = new Object[] { paramArrayOfObject, Integer.valueOf(i), str };
      this.q.sendMessage((Message)localObject);
      return;
    }
    catch (Throwable paramArrayOfObject)
    {
      for (;;)
      {
        QLog.e("WeiyunShareProcessController<FileAssistant>", 2, "GetQrTask error", paramArrayOfObject);
        paramArrayOfObject = null;
      }
    }
  }
  
  private void ah(Object[] paramArrayOfObject)
  {
    if ((paramArrayOfObject == null) || (paramArrayOfObject.length < 3)) {
      throw new IllegalArgumentException("handleQrRelay: args are invalid");
    }
    a((Bitmap)paramArrayOfObject[0], ((Integer)paramArrayOfObject[1]).intValue(), (String)paramArrayOfObject[2]);
  }
  
  private void b(FileManagerEntity paramFileManagerEntity, String paramString)
  {
    AppInterface localAppInterface = this.a.e().getAppInterface();
    if ((localAppInterface instanceof QQAppInterface))
    {
      Message localMessage = new Message();
      localMessage.what = 9;
      localMessage.obj = new Object[] { (QQAppInterface)localAppInterface, paramFileManagerEntity, this.a.a(), Boolean.valueOf(this.cfT), paramString };
      this.t.sendMessage(localMessage);
      return;
    }
    throw new IllegalStateException("processCloudFile: need QQAppInterface, must run in main process.");
  }
  
  private void dkK()
  {
    this.Di.setVisibility(0);
    TextView localTextView = this.SZ;
    if (this.cfT) {}
    for (int i = 2131700313;; i = 2131700315)
    {
      localTextView.setText(i);
      this.Ta.setText("");
      return;
    }
  }
  
  private void dkL()
  {
    aqju localaqju;
    if (this.ao == null)
    {
      this.ao = new aqju(this.a.e(), 2131756467);
      this.ao.setContentView(2131559151);
      this.ao.setTitle(2131700323);
      localaqju = this.ao;
      if (!this.cfT) {
        break label130;
      }
    }
    label130:
    for (int i = 2131700325;; i = 2131700324)
    {
      localaqju.setMessage(i);
      this.ao.setNegativeButton(2131721058, this);
      this.ao.setPositiveButton(2131700326, this);
      this.ao.setCancelable(true);
      this.ao.setCanceledOnTouchOutside(false);
      if (!this.ao.isShowing()) {
        this.ao.show();
      }
      return;
    }
  }
  
  private void dkM()
  {
    FileManagerEntity localFileManagerEntity = this.a.a();
    String str2 = this.a.getFilePath();
    if ((localFileManagerEntity == null) && (TextUtils.isEmpty(str2))) {
      QLog.w("WeiyunShareProcessController<FileAssistant>", 2, "startProcess: fileEntity and filePath are invalid");
    }
    while (this.mIsProcessing) {
      return;
    }
    this.mIsProcessing = true;
    this.a.dkG();
    Object localObject = this.a.a();
    String str1;
    if (this.cfT)
    {
      str1 = "0X800A9D7";
      String str3 = agyj.ei(((agyi.a)localObject).cYT);
      if (!this.cfT) {
        break label138;
      }
      localObject = null;
      label104:
      agyj.report(str1, str3, (String)localObject);
      if (!agyj.c(localFileManagerEntity, false)) {
        break label149;
      }
      b(localFileManagerEntity, str2);
    }
    for (;;)
    {
      dkK();
      return;
      str1 = "0X800A9D6";
      break;
      label138:
      localObject = agyj.t(((agyi.a)localObject).cfR);
      break label104;
      label149:
      JC(str2);
    }
  }
  
  private void dkN()
  {
    if (!TextUtils.isEmpty(vT()))
    {
      agyj.report("0X800A9D9", null, null);
      this.a.N(null);
    }
  }
  
  private void ni()
  {
    String str = vT();
    if (!TextUtils.isEmpty(str))
    {
      agyj.report("0X800A9D8", null, null);
      ClipboardManager localClipboardManager = (ClipboardManager)BaseApplicationImpl.sApplication.getSystemService("clipboard");
      alkw.a(localClipboardManager, str);
      localClipboardManager.setText(str);
      agyj.B(2, 2131700311, true);
    }
  }
  
  private void onError(int paramInt, String paramString)
  {
    reset();
    if (awou.nQ(paramInt))
    {
      dkL();
      return;
    }
    if (paramInt == 2) {
      paramString = BaseApplicationImpl.sApplication.getResources().getString(2131696272);
    }
    if (!TextUtils.isEmpty(paramString))
    {
      agyj.p(1, paramString, true);
      return;
    }
    paramString = BaseApplicationImpl.sApplication.getResources();
    if (this.cfT) {}
    for (int i = 2131700321;; i = 2131700322)
    {
      paramString = paramString.getString(i, new Object[] { Integer.valueOf(paramInt) });
      break;
    }
  }
  
  private String vT()
  {
    String str = this.Tb.getText().toString();
    if (!TextUtils.isEmpty(str))
    {
      Object localObject = this.Tb.getTag();
      if (((localObject instanceof String)) && (!TextUtils.isEmpty((String)localObject))) {
        return str + " " + BaseApplicationImpl.sApplication.getString(2131700337) + ":" + localObject;
      }
      return str;
    }
    return null;
  }
  
  public void dkJ()
  {
    agmv localagmv = this.b;
    this.b = null;
    if (localagmv != null) {
      localagmv.cancel();
    }
  }
  
  public void g(ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem)
  {
    int i = 1;
    if (paramActionSheetItem == null) {}
    int j;
    Object localObject1;
    String str;
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            j = paramActionSheetItem.action;
            localObject1 = this.a.e();
          } while ((localObject1 == null) || (((BaseActivity)localObject1).isFinishing()));
          if (aqiw.isNetSupport((Context)localObject1)) {
            break;
          }
          agyj.B(0, 2131693404, false);
        } while (!QLog.isColorLevel());
        QLog.i("WeiyunShareProcessController<FileAssistant>", 2, "toShare: net is not supported");
        return;
      } while ((j != 2) && (j != 3) && (j != 9) && (j != 10) && (j != 72));
      str = vT();
    } while (TextUtils.isEmpty(str));
    switch (j)
    {
    default: 
      return;
    case 2: 
      paramActionSheetItem = new Intent();
      paramActionSheetItem.putExtra("isFromShare", true);
      paramActionSheetItem.putExtra("forward_type", -1);
      paramActionSheetItem.putExtra("forward_text", str);
      ahgq.a((Activity)localObject1, paramActionSheetItem, 1, -1);
      return;
    case 3: 
      paramActionSheetItem = avpw.d.a();
      localObject2 = ((BaseActivity)localObject1).getAppInterface();
      paramActionSheetItem.cMP = ((AppInterface)localObject2).getAccount();
      paramActionSheetItem.nickname = ((AppInterface)localObject2).getDisplayName(0, ((AppInterface)localObject2).getCurrentAccountUin(), null);
      avpw.a((Activity)localObject1, paramActionSheetItem, "", ((BaseActivity)localObject1).getString(2131693309), str, 2);
      return;
    case 9: 
    case 10: 
      paramActionSheetItem = this.a.vS();
      localObject1 = WXShareHelper.a();
      if (j == 9) {
        i = 0;
      }
      ((WXShareHelper)localObject1).ah(str, i, paramActionSheetItem);
      return;
    }
    Object localObject2 = new Bundle();
    ((Bundle)localObject2).putInt("key_req", ForwardRecentActivity.bGS);
    ((Bundle)localObject2).putInt("key_direct_show_uin_type", paramActionSheetItem.uinType);
    ((Bundle)localObject2).putString("key_direct_show_uin", paramActionSheetItem.uin);
    paramActionSheetItem = new Intent();
    paramActionSheetItem.putExtra("isFromShare", true);
    paramActionSheetItem.putExtra("forward_type", -1);
    paramActionSheetItem.putExtra("forward_text", str);
    paramActionSheetItem.putExtras((Bundle)localObject2);
    ahgq.a((Activity)localObject1, paramActionSheetItem, ForwardRecentTranslucentActivity.class, 1, -1, "");
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (this.uU) {
      return false;
    }
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return true;
      aa((Object[])paramMessage.obj);
      continue;
      ac((Object[])paramMessage.obj);
      continue;
      ad((Object[])paramMessage.obj);
      continue;
      af((Object[])paramMessage.obj);
      continue;
      ah((Object[])paramMessage.obj);
      continue;
      ab((Object[])paramMessage.obj);
      continue;
      ae((Object[])paramMessage.obj);
      continue;
      ag((Object[])paramMessage.obj);
    }
  }
  
  public boolean isProcessing()
  {
    return this.mIsProcessing;
  }
  
  public boolean isUploading()
  {
    return this.b != null;
  }
  
  public List<ShareActionSheetBuilder.ActionSheetItem> m(Context paramContext)
  {
    paramContext = new ArrayList();
    paramContext.add(ShareActionSheetBuilder.ActionSheetItem.build(2));
    paramContext.add(ShareActionSheetBuilder.ActionSheetItem.build(3));
    paramContext.add(ShareActionSheetBuilder.ActionSheetItem.build(9));
    paramContext.add(ShareActionSheetBuilder.ActionSheetItem.build(10));
    return paramContext;
  }
  
  public List<ShareActionSheetBuilder.ActionSheetItem> n(Context paramContext)
  {
    return new ArrayList();
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramDialogInterface.equals(this.ao)) {}
    switch (paramInt)
    {
    case 0: 
    default: 
      return;
    }
    BaseActivity localBaseActivity = this.a.e();
    if (this.cfT) {}
    for (paramDialogInterface = "an_qq_qrcode_overcapacity";; paramDialogInterface = "an_qq_link_overcapacity")
    {
      awrl.h(localBaseActivity, paramDialogInterface, false);
      return;
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      dkM();
      continue;
      ni();
      continue;
      dkN();
    }
  }
  
  public void onDestroy()
  {
    this.uU = true;
    if (this.ao != null)
    {
      this.ao.dismiss();
      this.ao = null;
    }
    dkJ();
    this.q.removeCallbacksAndMessages(null);
    this.H.removeCallbacksAndMessages(null);
    this.t.removeCallbacksAndMessages(null);
  }
  
  public void reset()
  {
    this.Dg.setVisibility(0);
    this.fb.setVisibility(0);
    TextView localTextView = this.fb;
    if (this.cfT)
    {
      i = 2131700316;
      localTextView.setText(i);
      this.Dh.setVisibility(0);
      this.Di.setVisibility(8);
      localTextView = this.SZ;
      if (!this.cfT) {
        break label147;
      }
    }
    label147:
    for (int i = 2131700312;; i = 2131700314)
    {
      localTextView.setText(i);
      this.Ta.setVisibility(8);
      this.tt.setVisibility(8);
      this.Tb.setText("");
      this.Tb.setTag(null);
      boolean bool = this.mIsProcessing;
      this.mIsProcessing = false;
      if (bool) {
        this.a.dkG();
      }
      this.mShareUrl = null;
      return;
      i = 2131700317;
      break;
    }
  }
  
  static final class a
    implements agmf.a
  {
    private final WeakReference<agyk> aB;
    private final String aRN;
    private final String bJw;
    private final int cYT;
    private final boolean cfT;
    
    private a(agyk paramagyk, int paramInt, String paramString1, String paramString2, boolean paramBoolean)
    {
      if (paramagyk == null) {}
      for (paramagyk = null;; paramagyk = new WeakReference(paramagyk))
      {
        this.aB = paramagyk;
        this.cYT = paramInt;
        this.aRN = paramString1;
        this.bJw = paramString2;
        this.cfT = paramBoolean;
        return;
      }
    }
    
    public void onError(int paramInt, String paramString)
    {
      if (this.aB == null) {}
      for (agyk localagyk = null; (localagyk == null) || (agyk.a(localagyk)); localagyk = (agyk)this.aB.get()) {
        return;
      }
      if ((!awou.nQ(paramInt)) && (!TextUtils.isEmpty(this.bJw)) && (agyk.a(localagyk) == null))
      {
        QLog.w("WeiyunShareProcessController<FileAssistant>", 2, "GetShareLink errorCode=" + paramInt + ", errorMsg=" + paramString);
        agyk.a(localagyk, this.bJw);
        return;
      }
      Message localMessage = new Message();
      localMessage.what = 6;
      localMessage.obj = new Object[] { Integer.valueOf(paramInt), paramString };
      agyk.a(localagyk).sendMessage(localMessage);
    }
    
    public void onSuccess(Object paramObject)
    {
      if (this.aB == null) {}
      for (agyk localagyk = null; (paramObject == null) || (localagyk == null) || (agyk.a(localagyk)); localagyk = (agyk)this.aB.get()) {
        return;
      }
      Object localObject = (String)paramObject;
      paramObject = localObject;
      if (this.cfT)
      {
        paramObject = localObject;
        if (!((String)localObject).contains("?weiyun_qr_code=1")) {
          paramObject = (String)localObject + "?weiyun_qr_code=1";
        }
      }
      localObject = new Message();
      ((Message)localObject).what = 5;
      ((Message)localObject).obj = new Object[] { paramObject, Integer.valueOf(this.cYT), this.aRN };
      agyk.a(localagyk).sendMessage((Message)localObject);
    }
  }
  
  static final class b
    implements UploadManager.IUploadStatusListener
  {
    private final WeakReference<agyk> aB;
    private final String mFilePath;
    
    private b(agyk paramagyk, String paramString)
    {
      if (paramagyk == null) {}
      for (paramagyk = null;; paramagyk = new WeakReference(paramagyk))
      {
        this.aB = paramagyk;
        this.mFilePath = paramString;
        return;
      }
    }
    
    public void onUploadJobAdded(String paramString, long paramLong) {}
    
    public void onUploadStatusChanged(String paramString, long paramLong, UploadJobContext.StatusInfo paramStatusInfo, boolean paramBoolean)
    {
      agyk localagyk;
      if (this.aB == null)
      {
        localagyk = null;
        if ((localagyk != null) && (!agyk.a(localagyk))) {
          break label39;
        }
      }
      label39:
      while (agyk.a(localagyk) == null)
      {
        return;
        localagyk = (agyk)this.aB.get();
        break;
      }
      if (paramBoolean)
      {
        switch (paramStatusInfo.state)
        {
        default: 
          label80:
          paramString = null;
        }
        while (paramString != null)
        {
          agyk.a(localagyk).sendMessage(paramString);
          return;
          if (paramStatusInfo.errorCode == 1810002)
          {
            if (!QLog.isColorLevel()) {
              break label80;
            }
            QLog.i("WeiyunShareProcessController<FileAssistant>", 2, "upload is canceled, for file:" + this.mFilePath);
            paramString = null;
            continue;
          }
          paramString = new Message();
          paramString.what = 3;
          paramString.obj = new Object[] { Integer.valueOf(paramStatusInfo.errorCode), paramStatusInfo.errorMsg };
          continue;
          paramString = new Message();
          paramString.what = 2;
          paramString.obj = new Object[] { paramStatusInfo, this.mFilePath };
        }
      }
      if (paramStatusInfo.totalSize <= 0L) {}
      for (float f = 0.0F;; f = (float)paramStatusInfo.currSize / (float)paramStatusInfo.totalSize)
      {
        paramString = new Message();
        paramString.what = 4;
        paramString.obj = new Object[] { Float.valueOf(f) };
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     agyk
 * JD-Core Version:    0.7.0.1
 */