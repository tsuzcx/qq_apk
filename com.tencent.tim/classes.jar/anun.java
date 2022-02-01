import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawableDownListener.Adapter;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.MediaPlayerManager;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.structmsg.view.StructMsgItemPAAudio.3;
import com.tencent.mobileqq.widget.AnyScaleTypeImageView;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.lang.ref.WeakReference;
import localpb.richMsg.RichMsg.PttRec;
import org.xmlpull.v1.XmlSerializer;

public class anun
  extends anqu
  implements wla.a
{
  ImageView DN;
  ImageView DO;
  int aCy;
  MediaPlayerManager b;
  String cio;
  String cip;
  public ViewGroup ez;
  View.OnClickListener fN = new anuo(this);
  public boolean isPlaying = false;
  QQAppInterface mApp;
  int mBusiType;
  public String mCoverUrl;
  int mDuration;
  String mFileName;
  public String mPeerUin;
  URLDrawableDownListener.Adapter mUrlAdapter = new anup(this);
  
  public anun()
  {
    this.mTypeName = "paaudio";
  }
  
  public View a(Context paramContext, View paramView, Bundle paramBundle)
  {
    boolean bool2 = paramBundle.getBoolean("isSubscript", false);
    this.mApp = ((BaseActivity)paramContext).app;
    this.b = ((MediaPlayerManager)this.mApp.getManager(24));
    Resources localResources = paramContext.getResources();
    Object localObject;
    if ((paramView != null) && ((paramView.getTag() instanceof anun.a)))
    {
      localObject = (anun.a)paramView.getTag();
      ((anun.a)localObject).Hy.clearAnimation();
      ((TextView)((anun.a)localObject).Hz).setText(String.valueOf(this.mDuration) + "''");
    }
    for (;;)
    {
      int i;
      boolean bool1;
      try
      {
        paramBundle = localResources.getDrawable(2130842577);
        if (TextUtils.isEmpty(this.mCoverUrl))
        {
          ((AnyScaleTypeImageView)((anun.a)localObject).EY).setBackgroundDrawable(paramBundle);
          if (TextUtils.isEmpty(this.mCoverUrl)) {
            continue;
          }
          if (paramView.findViewById(97) == null)
          {
            paramContext = new View(paramContext);
            paramContext.setId(97);
            if (!bool2) {
              continue;
            }
            paramBundle = new RelativeLayout.LayoutParams(-1, (int)(BaseChatItemLayout.widthPixels / 2.4D * 0.69D));
            paramBundle.addRule(12, -1);
            paramContext.setBackgroundResource(2130842597);
            ((RelativeLayout)paramView).addView(paramContext, paramBundle);
          }
          paramContext = (Context)localObject;
          paramBundle = paramView;
          paramView = paramContext;
          paramBundle.post(new StructMsgItemPAAudio.3(this, paramBundle, paramView));
          paramView.localPath = aomk.q(this.mApp, this.cip);
          paramBundle.setTag(paramView);
          this.DN = ((ImageView)paramView.Ht);
          this.DO = ((ImageView)paramView.Hy);
          if (this.hU != null)
          {
            paramBundle.setOnLongClickListener((View.OnLongClickListener)this.hU.get());
            paramBundle.setOnTouchListener((View.OnTouchListener)this.hU.get());
          }
          paramBundle.setOnClickListener(this.fN);
          return paramBundle;
        }
      }
      catch (OutOfMemoryError paramBundle)
      {
        paramBundle = null;
        continue;
        i = localResources.getDisplayMetrics().widthPixels;
        paramBundle = URLDrawable.getDrawable(this.mCoverUrl, i, i, paramBundle, paramBundle);
        if ((aoiz.hasFile(this.mCoverUrl)) || (!aoop.bD(paramContext)))
        {
          bool1 = true;
          paramBundle.setAutoDownload(bool1);
          if ((paramBundle != null) && (paramBundle.getStatus() == 1))
          {
            ((AnyScaleTypeImageView)((anun.a)localObject).EY).setBackgroundDrawable(null);
            ((AnyScaleTypeImageView)((anun.a)localObject).EY).setBackgroundDrawable(paramBundle);
          }
        }
        else
        {
          bool1 = false;
          continue;
        }
        ((AnyScaleTypeImageView)((anun.a)localObject).EY).setURLDrawableDownListener(this.mUrlAdapter);
        ((anun.a)localObject).EY.setBackgroundColor(15790320);
        continue;
        paramBundle = new RelativeLayout.LayoutParams(-1, -1);
        paramContext.setBackgroundColor(Color.parseColor("#1A000000"));
        ((RelativeLayout)paramView).addView(paramContext, paramBundle);
        continue;
        paramContext = paramView.findViewById(97);
        if (paramContext == null) {
          continue;
        }
        ((RelativeLayout)paramView).removeView(paramContext);
        continue;
      }
      paramBundle = new anun.a();
      localObject = new RelativeLayout(paramContext);
      paramBundle.EY = new AnyScaleTypeImageView(paramContext);
      paramBundle.EY.setContentDescription(localResources.getString(2131696498));
      ((AnyScaleTypeImageView)paramBundle.EY).setDisplayRuleDef(arfd.b);
      ((AnyScaleTypeImageView)paramBundle.EY).setScaleType(ImageView.ScaleType.CENTER_INSIDE);
      try
      {
        paramView = localResources.getDrawable(2130842577);
        if (TextUtils.isEmpty(this.mCoverUrl))
        {
          ((AnyScaleTypeImageView)paramBundle.EY).setBackgroundDrawable(paramView);
          paramBundle.Ht = new ImageView(paramContext);
          paramBundle.Ht.setId(99);
          paramBundle.Ht.setBackgroundResource(2130842588);
          paramBundle.Hy = new ImageView(paramContext);
          paramBundle.Hy.setId(98);
          paramBundle.Hy.setBackgroundResource(2130842633);
          paramBundle.Hz = new TextView(paramContext);
          ((TextView)paramBundle.Hz).setText(String.valueOf(this.mDuration) + "'");
          ((TextView)paramBundle.Hz).setTextSize(20.0F);
          ((TextView)paramBundle.Hz).setTextColor(-1);
          paramView = new RelativeLayout.LayoutParams(-1, -1);
          ((RelativeLayout)localObject).addView(paramBundle.EY, paramView);
          if (!TextUtils.isEmpty(this.mCoverUrl))
          {
            paramContext = new View(paramContext);
            paramContext.setId(97);
            if (!bool2) {
              break label1179;
            }
            paramView = new RelativeLayout.LayoutParams(-1, (int)(BaseChatItemLayout.widthPixels / 2.4D * 0.69D));
            paramView.addRule(12, -1);
            paramContext.setBackgroundResource(2130842597);
            ((RelativeLayout)localObject).addView(paramContext, paramView);
          }
          paramContext = new RelativeLayout.LayoutParams(wja.dp2px(12.0F, localResources), wja.dp2px(20.0F, localResources));
          paramContext.addRule(9, -1);
          paramContext.setMargins(wja.dp2px(20.0F, localResources), 0, 0, 0);
          paramContext.addRule(15, -1);
          ((RelativeLayout)localObject).addView(paramBundle.Ht, paramContext);
          paramContext = new RelativeLayout.LayoutParams(wja.dp2px(14.0F, localResources), wja.dp2px(20.0F, localResources));
          paramContext.setMargins(wja.dp2px(5.0F, localResources), 0, 0, 0);
          paramContext.addRule(15, -1);
          paramContext.addRule(1, paramBundle.Ht.getId());
          ((RelativeLayout)localObject).addView(paramBundle.Hy, paramContext);
          paramContext = new RelativeLayout.LayoutParams(-2, -2);
          paramContext.setMargins(wja.dp2px(15.0F, localResources), 0, 0, 0);
          paramContext.addRule(15, -1);
          paramContext.addRule(1, paramBundle.Hy.getId());
          ((RelativeLayout)localObject).addView(paramBundle.Hz, paramContext);
          paramContext = (Context)localObject;
          paramView = paramBundle;
          paramBundle = paramContext;
        }
      }
      catch (OutOfMemoryError paramView)
      {
        for (;;)
        {
          paramView = null;
          continue;
          i = localResources.getDisplayMetrics().widthPixels;
          paramView = URLDrawable.getDrawable(this.mCoverUrl, i, i, paramView, paramView);
          if ((aoiz.hasFile(this.mCoverUrl)) || (!aoop.bD(paramContext)))
          {
            bool1 = true;
            label1103:
            paramView.setAutoDownload(bool1);
            if ((paramView == null) || (paramView.getStatus() != 1)) {
              break label1152;
            }
            ((AnyScaleTypeImageView)paramBundle.EY).setBackgroundDrawable(null);
          }
          for (;;)
          {
            ((AnyScaleTypeImageView)paramBundle.EY).setBackgroundDrawable(paramView);
            break;
            bool1 = false;
            break label1103;
            label1152:
            ((AnyScaleTypeImageView)paramBundle.EY).setURLDrawableDownListener(this.mUrlAdapter);
            paramBundle.EY.setBackgroundColor(15790320);
          }
          label1179:
          paramView = new RelativeLayout.LayoutParams(-1, -1);
          paramContext.setBackgroundColor(Color.parseColor("#1A000000"));
          ((RelativeLayout)localObject).addView(paramContext, paramView);
        }
      }
    }
  }
  
  public void a(View paramView, aoko paramaoko, int paramInt1, int paramInt2)
  {
    if ((paramaoko.fileType != 33) || (paramInt1 == 2002) || (paramInt1 == 2001)) {}
    while ((paramInt1 != 2003) || (this.mApp == null)) {
      return;
    }
    dTB();
    play();
  }
  
  public void a(XmlSerializer paramXmlSerializer)
    throws IOException
  {
    paramXmlSerializer.startTag(null, "paaudio");
    paramXmlSerializer.attribute(null, "cover", this.mCoverUrl);
    paramXmlSerializer.attribute(null, "busitype", String.valueOf(this.mBusiType));
    paramXmlSerializer.attribute(null, "duration", String.valueOf(this.mDuration));
    paramXmlSerializer.attribute(null, "md5", this.cio);
    paramXmlSerializer.attribute(null, "filename", this.mFileName);
    paramXmlSerializer.attribute(null, "filesize", String.valueOf(this.aCy));
    paramXmlSerializer.attribute(null, "uuid", this.cip);
    paramXmlSerializer.endTag(null, "paaudio");
  }
  
  public boolean a(ansf paramansf)
  {
    if (paramansf == null) {
      return true;
    }
    this.mCoverUrl = paramansf.getAttribute("cover");
    this.mBusiType = Integer.parseInt(paramansf.getAttribute("busitype"));
    this.mDuration = Integer.parseInt(paramansf.getAttribute("duration"));
    this.cio = paramansf.getAttribute("md5");
    this.mFileName = paramansf.getAttribute("filename");
    this.aCy = Integer.parseInt(paramansf.getAttribute("filesize"));
    this.cip = paramansf.getAttribute("uuid");
    return true;
  }
  
  public boolean cK(long paramLong)
  {
    ChatMessage localChatMessage = this.b.a();
    if (localChatMessage == null) {}
    while (localChatMessage.uniseq != paramLong) {
      return false;
    }
    return true;
  }
  
  void dTA()
  {
    this.DN.setBackgroundResource(2130772189);
    ((AnimationDrawable)this.DN.getBackground()).start();
  }
  
  void dTB()
  {
    this.DN.clearAnimation();
    this.DN.setBackgroundResource(2130842588);
    if (this.isPlaying)
    {
      this.DO.setBackgroundResource(2130772190);
      ((AnimationDrawable)this.DO.getBackground()).start();
      return;
    }
    this.DO.clearAnimation();
    this.DO.setBackgroundResource(2130842633);
  }
  
  void e(String paramString, View paramView)
  {
    if (aiyy.a().apY())
    {
      paramString = paramView.getContext();
      aqha.a(paramString, 232, null, paramString.getString(2131693404), new anuq(this), null).show();
      dTB();
      return;
    }
    wla.a(this.mApp).a(paramView, this);
    Object localObject = new RichMsg.PttRec();
    ((RichMsg.PttRec)localObject).localPath.set(this.cip);
    ((RichMsg.PttRec)localObject).size.set(this.aCy);
    ((RichMsg.PttRec)localObject).type.set(2);
    ((RichMsg.PttRec)localObject).uuid.set(this.cip);
    ((RichMsg.PttRec)localObject).isRead.set(false);
    ((RichMsg.PttRec)localObject).serverStorageSource.set("pttcenter");
    ((RichMsg.PttRec)localObject).isReport.set(0);
    ((RichMsg.PttRec)localObject).version.set(5);
    ((RichMsg.PttRec)localObject).pttFlag.set(0);
    ((RichMsg.PttRec)localObject).longPttVipFlag.set(0);
    long l = System.currentTimeMillis() / 1000L;
    ((RichMsg.PttRec)localObject).msgRecTime.set(l);
    ((RichMsg.PttRec)localObject).msgTime.set(0L);
    ((RichMsg.PttRec)localObject).voiceChangeFlag.set(0);
    ((RichMsg.PttRec)localObject).busiType.set(this.mBusiType);
    paramView = anbi.d(-2002);
    paramView.frienduin = paramString;
    paramView.istroop = 1008;
    paramView.msgData = ((RichMsg.PttRec)localObject).toByteArray();
    ((MessageForPtt)paramView).doParse();
    for (;;)
    {
      try
      {
        localObject = new aool();
        ((aool)localObject).mSelfUin = this.mApp.getAccount();
        ((aool)localObject).mPeerUin = paramString;
        ((aool)localObject).mUinType = 1008;
        ((aool)localObject).mFileType = 33;
        ((aool)localObject).mUniseq = paramView.uniseq;
        ((aool)localObject).cNy = false;
        ((aool)localObject).cmo = ((MessageForPtt)paramView).urlAtServer;
        ((aool)localObject).clR = ((MessageForPtt)paramView).getLocalFilePath();
        if (paramView.isSendFromOtherTerminal()) {
          break label457;
        }
        if (!paramView.isSend()) {
          break label451;
        }
      }
      catch (Exception paramString)
      {
        QLog.d("structmsg.StructMsgItemPAAudio", 2, paramString.getMessage());
        return;
      }
      ((aool)localObject).cNz = bool;
      ((aool)localObject).mMd5 = ((MessageForPtt)paramView).md5;
      ((aool)localObject).apQ = ((MessageForPtt)paramView).groupFileID;
      ((aool)localObject).clM = ((MessageForPtt)paramView).groupFileKeyStr;
      ((aool)localObject).dQF = ((MessageForPtt)paramView).subVersion;
      ((aool)localObject).F = paramView;
      ((aool)localObject).en = new aool.e(1, 0);
      this.mApp.a().a((aool)localObject);
      return;
      label451:
      boolean bool = false;
      continue;
      label457:
      bool = true;
    }
  }
  
  public String getLayoutStr()
  {
    return "paaudio";
  }
  
  public void play()
  {
    if (this.isPlaying) {}
    while (this.ez == null) {
      return;
    }
    this.isPlaying = true;
    this.b.k(((wko.a)wja.a(this.ez)).mMessage);
    this.DO.clearAnimation();
    this.DO.setBackgroundResource(2130772190);
    ((AnimationDrawable)this.DO.getBackground()).start();
  }
  
  public void readExternal(ObjectInput paramObjectInput)
    throws IOException
  {
    super.readExternal(paramObjectInput);
    this.mCoverUrl = paramObjectInput.readUTF();
    this.mBusiType = paramObjectInput.readInt();
    this.mDuration = paramObjectInput.readInt();
    this.cio = paramObjectInput.readUTF();
    this.mFileName = paramObjectInput.readUTF();
    this.aCy = paramObjectInput.readInt();
    this.cip = paramObjectInput.readUTF();
  }
  
  public void stop()
  {
    if (!this.isPlaying) {}
    while (this.ez == null) {
      return;
    }
    this.isPlaying = false;
    MediaPlayerManager localMediaPlayerManager = (MediaPlayerManager)this.mApp.getManager(24);
    if (((wko.a)wja.a(this.ez)).mMessage.equals(localMediaPlayerManager.a())) {
      localMediaPlayerManager.stop(false);
    }
    this.DO.clearAnimation();
    this.DO.setBackgroundResource(2130842633);
  }
  
  public void writeExternal(ObjectOutput paramObjectOutput)
    throws IOException
  {
    super.writeExternal(paramObjectOutput);
    paramObjectOutput.writeUTF(this.mCoverUrl);
    paramObjectOutput.writeInt(this.mBusiType);
    paramObjectOutput.writeInt(this.mDuration);
    if (this.cio == null)
    {
      str = "";
      paramObjectOutput.writeUTF(str);
      if (this.mFileName != null) {
        break label108;
      }
      str = "";
      label64:
      paramObjectOutput.writeUTF(str);
      paramObjectOutput.writeInt(this.aCy);
      if (this.cip != null) {
        break label116;
      }
    }
    label108:
    label116:
    for (String str = "";; str = this.cip)
    {
      paramObjectOutput.writeUTF(str);
      return;
      str = this.cio;
      break;
      str = this.mFileName;
      break label64;
    }
  }
  
  public static class a
  {
    public View EY;
    public View Ht;
    public View Hy;
    public View Hz;
    public String localPath;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     anun
 * JD-Core Version:    0.7.0.1
 */