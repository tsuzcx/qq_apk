import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.vaswebviewplugin.EmojiHomeUiPlugin;
import com.tencent.mobileqq.widget.ProgressButton;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.net.MalformedURLException;
import java.net.URL;
import mqq.os.MqqHandler;

public class afnz
  extends afoi
  implements Handler.Callback, View.OnClickListener
{
  protected afnz.a a;
  private int authType = 2;
  protected boolean bZS;
  protected boolean bZT;
  private int businessType;
  protected EmoticonPackage d;
  private MqqHandler q = new aurf(Looper.getMainLooper(), this, true);
  
  public afnz(QQAppInterface paramQQAppInterface, Context paramContext, int paramInt1, int paramInt2, int paramInt3, EmoticonPackage paramEmoticonPackage, afmf paramafmf, int paramInt4)
  {
    super(paramQQAppInterface, paramContext, paramInt1, paramInt2, paramInt3, paramafmf);
    this.d = paramEmoticonPackage;
    if (paramEmoticonPackage.jobType == 4) {}
    for (boolean bool = true;; bool = false)
    {
      this.bZS = bool;
      this.businessType = paramInt4;
      return;
    }
  }
  
  private void Id(boolean paramBoolean)
  {
    if ((this.d == null) || (this.jdField_a_of_type_Afnz$a == null)) {}
    ProgressButton localProgressButton;
    do
    {
      do
      {
        return;
        if (QLog.isColorLevel()) {
          QLog.d(TAG, 2, "doDownloadOpr epid = " + this.d.epId);
        }
        localProgressButton = this.jdField_a_of_type_Afnz$a.a;
      } while (localProgressButton == null);
      if (!paramBoolean) {
        break;
      }
      daV();
    } while (this.authType != 2);
    afke localafke = (afke)this.app.getManager(43);
    if ((this.d.epId != null) && (this.d.epId.equals("10278")))
    {
      ((acdz)this.app.getBusinessHandler(12)).dt(this.d.epId, this.businessType);
      anot.a(this.app, "CliOper", "", "", "ep_mall", "Ep_endoffer_click", 0, 0, "", "", "", "");
    }
    localProgressButton.setProgressDrawable(localProgressButton.a(-16745986));
    float f = localafke.e(this.d.epId);
    int i;
    if (this.cSJ == 2)
    {
      localProgressButton.setText(acfp.m(2131705882));
      localProgressButton.setProgress((int)f);
      localafke.a(this.d, true, this.businessType);
      this.cSJ = 1;
      i = 1;
    }
    for (;;)
    {
      anot.a(this.app, "CliOper", "", "", "ep_mall", "0X80057B1", 0, 0, "", this.d.epId, i + "", "");
      return;
      if (this.cSJ == 1)
      {
        String str = acfp.m(2131705877);
        if (this.bZT) {
          str = acfp.m(2131705874);
        }
        localProgressButton.setText(str);
        localProgressButton.setProgress(0);
        this.cSJ = 2;
        localafke.HX(this.d.epId);
        this.mContext.getSharedPreferences("mobileQQ", 0).edit().remove("LAST_ADD_EMO_PACKAGE").commit();
        i = 2;
      }
      else
      {
        i = 1;
      }
    }
  }
  
  private boolean ajE()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.jdField_a_of_type_Afoo != null)
    {
      bool1 = bool2;
      if (this.jdField_a_of_type_Afoo.d != null)
      {
        bool1 = bool2;
        if (this.d != null)
        {
          bool1 = bool2;
          if (!TextUtils.isEmpty(this.d.epId))
          {
            EmoticonPackage localEmoticonPackage = this.jdField_a_of_type_Afoo.d;
            bool1 = bool2;
            if (this.d.epId.equals(localEmoticonPackage.epId)) {
              bool1 = true;
            }
          }
        }
      }
    }
    return bool1;
  }
  
  private void daV()
  {
    if (this.d == null) {
      return;
    }
    int i = ((acle)this.app.getBusinessHandler(13)).AX();
    if (this.d.mobileFeetype == 4)
    {
      if ((i == 1) || (i == 3))
      {
        this.authType = 2;
        return;
      }
      this.authType = 0;
      return;
    }
    if (this.d.mobileFeetype == 5)
    {
      if (i == 3)
      {
        this.authType = 2;
        return;
      }
      this.authType = 1;
      return;
    }
    this.authType = 2;
  }
  
  public void MQ(int paramInt)
  {
    if (paramInt == 18)
    {
      if (QLog.isColorLevel()) {
        QLog.d(TAG, 2, "payback");
      }
      if (ajE())
      {
        Id(true);
        if ((this.bZS) && (this.d != null)) {
          anot.a(this.app, "CliOper", "", "", "ep_mall", "0X80057AD", 0, 0, this.d.epId, "", "", "");
        }
      }
    }
  }
  
  public afll.a a()
  {
    return new afnz.a();
  }
  
  public View a(afll.a parama, int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    return null;
  }
  
  public void a(afnz.a parama)
  {
    if ((parama == null) || (this.d == null) || (TextUtils.isEmpty(this.d.epId)))
    {
      QLog.e(TAG, 1, "updateUI holder is null");
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "updateUI epid = " + this.d.epId);
    }
    parama.name.setText(this.d.name);
    parama.name.setVisibility(0);
    Object localObject = afgc.z(2, this.d.epId);
    String str;
    for (;;)
    {
      try
      {
        localDrawable1 = BaseApplicationImpl.getApplication().getResources().getDrawable(2130838097);
        localDrawable2 = BaseApplicationImpl.getApplication().getResources().getDrawable(2130844558);
        if (!aqhq.fileExists((String)localObject)) {
          continue;
        }
        localObject = aoop.getDrawable(new URL("file:///" + (String)localObject), localDrawable1, localDrawable2);
        if (localObject == null) {
          continue;
        }
        parama.d.setImageDrawable((Drawable)localObject);
      }
      catch (MalformedURLException localMalformedURLException)
      {
        Drawable localDrawable1;
        Drawable localDrawable2;
        float f;
        parama.d.setImageResource(2130844558);
        continue;
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        parama.d.setImageResource(2130844558);
        continue;
        str = acfp.m(2131705881);
        if (!this.bZT) {
          break;
        }
      }
      parama.d.setVisibility(0);
      f = ((afke)this.app.getManager(43)).e(this.d.epId);
      if (QLog.isColorLevel()) {
        QLog.d(TAG, 2, "Ep id=" + this.d.epId + ", progress=" + f);
      }
      if (f >= 0.0F)
      {
        parama.a.setVisibility(0);
        parama.a.setProgress((int)(f * 100.0F));
        parama.a.setText(acfp.m(2131705875));
        this.cSJ = 1;
        parama.a.setOnClickListener(this);
        return;
        if (this.bZS)
        {
          localObject = afgc.A(19, this.d.epId);
          localObject = aoop.getDrawable((String)localObject, localDrawable1, localDrawable2);
        }
        else
        {
          localObject = afgc.A(2, this.d.epId);
          continue;
          parama.d.setImageResource(2130844558);
        }
      }
      else
      {
        str = acfp.m(2131705878);
      }
    }
    for (;;)
    {
      parama.a.setVisibility(0);
      parama.a.setProgress(0);
      parama.a.setText(str);
      this.cSJ = 2;
      if (!ajE()) {
        break;
      }
      dah();
      break;
      if ((this.d.mobileFeetype == 4) || (this.d.mobileFeetype == 5))
      {
        daV();
        if (this.authType != 2) {
          str = acfp.m(2131705880);
        }
      }
      else if (!this.d.valid)
      {
        str = acfp.m(2131705876);
      }
    }
  }
  
  public void d(EmoticonPackage paramEmoticonPackage, int paramInt)
  {
    if ((paramInt != 0) || (paramEmoticonPackage == null)) {
      return;
    }
    Message localMessage = Message.obtain();
    localMessage.what = 102;
    localMessage.obj = paramEmoticonPackage;
    localMessage.arg1 = paramInt;
    this.q.sendMessage(localMessage);
  }
  
  public void dah()
  {
    if ((this.d == null) || (TextUtils.isEmpty(this.d.epId))) {
      QLog.e(TAG, 1, "onAdapterSelected emotionpkg = null");
    }
    do
    {
      return;
      if ((this.d.mobileFeetype != 4) && (this.d.mobileFeetype != 5)) {
        break;
      }
      daV();
    } while (this.authType != 2);
    while (this.d.valid)
    {
      afke localafke = (afke)this.app.getManager(43);
      if ((localafke.e(this.d.epId) >= 0.0F) || (!afnu.isWifi())) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.d(TAG, 2, "wifi auto download emotion , epid = " + this.d.epId);
      }
      localafke.a(this.d, false, this.businessType);
      if ((this.jdField_a_of_type_Afnz$a != null) && (this.jdField_a_of_type_Afnz$a.a != null))
      {
        this.jdField_a_of_type_Afnz$a.a.setVisibility(0);
        this.jdField_a_of_type_Afnz$a.a.setText(acfp.m(2131705879));
        this.cSJ = 1;
      }
      anot.a(this.app, "CliOper", "", "", "ep_mall", "0X80057B1", 0, 0, this.d.epId, "", "", "");
      return;
    }
  }
  
  public void f(EmoticonPackage paramEmoticonPackage, int paramInt1, int paramInt2)
  {
    if (paramEmoticonPackage == null) {
      return;
    }
    Message localMessage = Message.obtain();
    localMessage.what = 101;
    localMessage.obj = paramEmoticonPackage;
    this.q.sendMessage(localMessage);
  }
  
  public int getItemViewType(int paramInt)
  {
    if (this.bZT)
    {
      if (paramInt == 0) {
        return 0;
      }
      return 1;
    }
    return super.getItemViewType(paramInt);
  }
  
  public int getViewTypeCount()
  {
    if (this.bZT) {
      return 2;
    }
    return super.getViewTypeCount();
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    EmoticonPackage localEmoticonPackage = (EmoticonPackage)paramMessage.obj;
    if ((this.jdField_a_of_type_Afnz$a == null) || (this.jdField_a_of_type_Afnz$a.d == null)) {
      QLog.e(TAG, 1, "packageDownloadEnd view is null");
    }
    do
    {
      do
      {
        do
        {
          return true;
        } while ((this.d == null) || (TextUtils.isEmpty(this.d.epId)) || (localEmoticonPackage == null) || (!this.d.epId.equals(localEmoticonPackage.epId)));
        switch (paramMessage.what)
        {
        default: 
          return true;
        case 100: 
          if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "handleMessage refreshCover epid = " + this.d.epId);
          }
          paramMessage = afgc.c(2, this.d.epId);
        }
      } while (paramMessage == null);
      this.jdField_a_of_type_Afnz$a.d.setImageDrawable(paramMessage);
      return true;
      paramMessage = afke.a(((BaseActivity)this.mContext).getAppRuntime(), localEmoticonPackage.epId);
    } while (paramMessage == null);
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "handleMessage refreshprogress epid = " + this.d.epId);
    }
    int i = (int)paramMessage.ba();
    this.jdField_a_of_type_Afnz$a.a.setText(acfp.m(2131705872));
    this.cSJ = 1;
    this.jdField_a_of_type_Afnz$a.a.setProgressDrawable(this.jdField_a_of_type_Afnz$a.a.a(-16745986));
    this.jdField_a_of_type_Afnz$a.a.setProgress(i);
    return true;
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "handleMessage packageDownloadEnd epid = " + this.d.epId);
    }
    if (this.bZT) {
      this.jdField_a_of_type_Afnz$a.a.setText(acfp.m(2131705873));
    }
    this.jdField_a_of_type_Afnz$a.a.setText(acfp.m(2131705871));
    this.jdField_a_of_type_Afnz$a.a.setProgress(0);
    this.cSJ = 2;
    return true;
  }
  
  public void k(EmoticonPackage paramEmoticonPackage)
  {
    if (paramEmoticonPackage == null) {
      return;
    }
    Message localMessage = Message.obtain();
    localMessage.what = 100;
    localMessage.obj = paramEmoticonPackage;
    this.q.sendMessage(localMessage);
  }
  
  public void onClick(View paramView)
  {
    if ((paramView.getId() != 2131365570) || (this.d == null)) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if ((this.d.mobileFeetype == 4) || (this.d.mobileFeetype == 5))
      {
        daV();
        if (this.authType != 2)
        {
          Object localObject = "mvip.g.a.bq_" + this.d.epId;
          String str = "!vip";
          if (this.d.mobileFeetype == 5) {
            str = "!svip";
          }
          str = "https://mc.vip.qq.com/qqwallet/index?aid=" + (String)localObject + "&type=" + str + "&send=0&return_url=jsbridge://qw_charge/emojiPayResultOk";
          localObject = new Intent(this.mContext, QQBrowserActivity.class);
          ((Intent)localObject).putExtra("url", str);
          if ((this.mContext instanceof Activity)) {
            ((Activity)this.mContext).startActivityForResult((Intent)localObject, 4813);
          }
          if (this.bZS) {
            continue;
          }
          anot.a(this.app, "CliOper", "", "", "ep_mall", "0X80057B3", 0, 0, this.d.epId, "", "", "");
        }
      }
      else if (!this.d.valid)
      {
        if (this.d.jobType == 4) {}
        for (boolean bool = true;; bool = false)
        {
          EmojiHomeUiPlugin.openEmojiDetailPage((Activity)this.mContext, this.app.getAccount(), 8, String.valueOf(this.d.epId), false, bool);
          break;
        }
      }
      Id(false);
    }
  }
  
  public static class a
    extends afll.a
  {
    public ProgressButton a;
    public URLImageView d;
    public TextView name;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afnz
 * JD-Core Version:    0.7.0.1
 */