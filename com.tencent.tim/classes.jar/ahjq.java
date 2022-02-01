import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.forward.ForwardQFavBatchOption.1;
import com.tencent.mobileqq.forward.ForwardQFavBatchOption.2;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Set;
import mqq.os.MqqHandler;

public class ahjq
  extends ahgq
{
  boolean chh = false;
  
  public ahjq(Intent paramIntent)
  {
    super(paramIntent);
  }
  
  private String e(Bundle paramBundle)
  {
    Object localObject1;
    if (paramBundle == null) {
      localObject1 = "";
    }
    Object localObject2;
    do
    {
      do
      {
        return localObject1;
        localObject2 = paramBundle.getString("forward_extra");
        localObject1 = localObject2;
      } while (paramBundle.getInt("qfavType") != 5);
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = paramBundle.getString("forward_extra");
      }
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = paramBundle.getString("forward_filepath");
      }
      localObject1 = localObject2;
    } while (localObject2 != null);
    return paramBundle.getString("GALLERY.FORWORD_LOCAL_PATH");
  }
  
  public boolean anj()
  {
    super.anj();
    this.chh = this.mIntent.getBooleanExtra("bSinglePicSelected", false);
    if ((this.chh) && (TextUtils.isEmpty(this.bKv))) {
      this.bKv = this.bf.getString("forward_filepath");
    }
    if (this.bf.getBoolean("qqfav_extra_skip_confirm", false)) {
      dnT();
    }
    Object localObject = this.mIntent.getParcelableArrayListExtra("bundleList");
    if ((localObject != null) && (((ArrayList)localObject).size() == 1))
    {
      localObject = (Bundle)((ArrayList)localObject).get(0);
      if (localObject == null) {
        return false;
      }
      if (((Bundle)localObject).getInt("qfavType") == 5) {
        this.bKv = ((Bundle)localObject).getString("forward_thumb");
      }
    }
    return true;
  }
  
  protected void dnP()
  {
    if (this.chh) {
      dnQ();
    }
  }
  
  public void dnT()
  {
    String str1 = this.bf.getString("troop_uin");
    String str2 = this.bf.getString("uin");
    String str3 = this.bf.getString("uinname");
    int k = this.bf.getInt("uintype");
    Object localObject2 = new Intent();
    boolean bool = this.mIntent.getBooleanExtra("needStartChatActivity", false);
    ((Intent)localObject2).putExtra("needStartChatActivity", bool);
    Object localObject1 = localObject2;
    if (bool)
    {
      localObject1 = wja.a((Intent)localObject2, null);
      ((Intent)localObject1).putExtras(this.bf);
    }
    this.mActivity.getIntent().putExtra("isFromFavorites", true);
    this.mActivity.setResult(-1, (Intent)localObject1);
    this.mActivity.finish();
    localObject1 = new Intent((Intent)localObject1);
    localObject2 = this.app.getCurrentAccountUin();
    int i;
    ArrayList localArrayList;
    int j;
    label191:
    Object localObject3;
    MqqHandler localMqqHandler;
    if (this.mIntent.getBooleanExtra("forwardFromAIO", false))
    {
      i = 2;
      localArrayList = this.mIntent.getParcelableArrayListExtra("bundleList");
      int m = this.bf.getInt("KEY_MSG_FORWARD_ID");
      j = 0;
      if (j >= localArrayList.size()) {
        break label288;
      }
      localObject3 = (Bundle)localArrayList.get(j);
      if (localObject3 != null)
      {
        localMqqHandler = ThreadManager.getUIHandler();
        localObject3 = new ForwardQFavBatchOption.1(this, (Bundle)localObject3, str2, str1, k, m, (String)localObject2, i, str3, (Intent)localObject1);
        if (j != 0) {
          break label278;
        }
      }
    }
    label278:
    for (long l = 200L;; l = j * 10)
    {
      localMqqHandler.postDelayed((Runnable)localObject3, l);
      j += 1;
      break label191;
      i = 1;
      break;
    }
    label288:
    avjg.a(this.app, "User_BatchForwardSendBtnClick", 0, 0, localArrayList.size());
  }
  
  protected void dnr()
  {
    super.dnr();
    Object localObject = this.mIntent.getParcelableArrayListExtra("bundleList");
    if (localObject != null)
    {
      j = 0;
      int i = 1;
      while (j < ((ArrayList)localObject).size())
      {
        if (((Bundle)((ArrayList)localObject).get(j)).getInt("qfavType") != 3) {
          i = 0;
        }
        j += 1;
      }
      j = i;
      if (((ArrayList)localObject).size() == 1)
      {
        localObject = (Bundle)((ArrayList)localObject).get(0);
        j = i;
        if (((Bundle)localObject).getInt("qfavType") == 5)
        {
          j = i;
          if (!((Bundle)localObject).getBoolean("k_dataline", false)) {}
        }
      }
    }
    for (int j = 1;; j = 1)
    {
      if (j != 0)
      {
        this.cs.add(W);
        this.cs.add(ab);
        this.mIntent.putExtra("isJumpAIO", true);
      }
      return;
    }
  }
  
  protected void dns()
  {
    this.e.setMessageWithEmo(this.bKu, this.mDensity);
    TextView localTextView = this.e.getMessageTextView();
    ViewGroup.LayoutParams localLayoutParams = localTextView.getLayoutParams();
    localLayoutParams.width = -1;
    localTextView.setLayoutParams(localLayoutParams);
    localTextView.setGravity(17);
  }
  
  protected void du(Intent paramIntent)
  {
    int i = 0;
    ArrayList localArrayList = this.mIntent.getParcelableArrayListExtra("bundleList");
    this.mActivity.getIntent().putExtra("isFromFavorites", true);
    this.mActivity.getIntent().putExtra("hasJumpAIO", true);
    this.mActivity.setResult(-1, paramIntent);
    this.mActivity.finish();
    Object localObject;
    if ((localArrayList != null) && (localArrayList.size() == 1))
    {
      localObject = e((Bundle)localArrayList.get(0));
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        paramIntent.putExtra("dataline_forward_type", 100);
        QLog.d("ForwardOption.ForwardQFavBatchOption", 1, "sendDatalineSingle filePath: " + (String)localObject);
        paramIntent.putExtra("dataline_forward_path", (String)localObject);
        auqv.aX(true, (String)localObject);
      }
    }
    if ((localArrayList != null) && (localArrayList.size() > 1))
    {
      boolean bool = this.mIntent.getBooleanExtra("needStartChatActivity", false);
      paramIntent.putExtra("needStartChatActivity", bool);
      if (bool) {
        wja.a(paramIntent, null).putExtras(this.bf);
      }
      int j = this.bf.getInt("KEY_MSG_FORWARD_ID");
      if (i < localArrayList.size())
      {
        localObject = (Bundle)localArrayList.get(i);
        if (localObject != null)
        {
          paramIntent = ThreadManager.getUIHandler();
          localObject = new ForwardQFavBatchOption.2(this, (Bundle)localObject, j);
          if (i != 0) {
            break label277;
          }
        }
        label277:
        for (long l = 200L;; l = i * 10)
        {
          paramIntent.postDelayed((Runnable)localObject, l);
          i += 1;
          break;
        }
      }
    }
  }
  
  public String wn()
  {
    ArrayList localArrayList;
    if (!this.chh)
    {
      localArrayList = this.mIntent.getParcelableArrayListExtra("bundleList");
      if (localArrayList == null) {}
    }
    for (this.bKu = (localArrayList.size() + this.mActivity.getString(2131700239));; this.bKu = null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ForwardOption.ForwardQFavBatchOption", 2, "DialogContent:mForwardText=" + this.bKu);
      }
      return this.bKu;
    }
  }
  
  public String wo()
  {
    String str = this.bf.getString("uinname");
    if (this.bf.getInt("key_forward_ability_type") == W.intValue()) {
      str = acfp.m(2131696154);
    }
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahjq
 * JD-Core Version:    0.7.0.1
 */