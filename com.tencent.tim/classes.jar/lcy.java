import android.app.Activity;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.view.Window;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyNewFeedsActivity;
import com.tencent.biz.pubaccount.readinjoy.redpacket.RIJRedPacketManager;
import com.tencent.biz.pubaccount.readinjoy.redpacket.RIJRedPacketManager.OpenRedPacketResultStruct;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import org.jetbrains.annotations.NotNull;

public class lcy
  extends lcs
  implements mef.b
{
  private mdw jdField_a_of_type_Mdw;
  private mek jdField_a_of_type_Mek = new mek(new meh());
  private int aNZ;
  private int aOa;
  private int aOb;
  private Activity activity;
  private boolean aju;
  @Nullable
  private String rowkey;
  
  public lcy(@NotNull lct paramlct, Activity paramActivity)
  {
    super(paramlct, "RIJRedPacketPopupStep");
    this.activity = paramActivity;
  }
  
  private boolean l(Activity paramActivity)
  {
    if ((RIJRedPacketManager.a().Dp()) && (!(paramActivity instanceof ReadInJoyNewFeedsActivity)))
    {
      this.jdField_a_of_type_Mek.a(this);
      this.jdField_a_of_type_Mek.b(this.rowkey, this.aNZ, this.aOa, this.aOb);
      RIJRedPacketManager.a().aOD();
      return true;
    }
    return false;
  }
  
  private boolean m(Activity paramActivity)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    Intent localIntent;
    String str;
    if (!(paramActivity instanceof ReadInJoyNewFeedsActivity))
    {
      localIntent = paramActivity.getIntent();
      int i = localIntent.getIntExtra("launch_from", 0);
      str = localIntent.getStringExtra("redpackid");
      if (i != 17) {
        break label218;
      }
      this.jdField_a_of_type_Mek.a(this);
      i = localIntent.getIntExtra("share_source_from_content", 5);
      int j = localIntent.getIntExtra("plat_source", 0);
      RIJRedPacketManager.OpenRedPacketResultStruct localOpenRedPacketResultStruct = (RIJRedPacketManager.OpenRedPacketResultStruct)localIntent.getParcelableExtra("key_open_red_packet_result");
      if (localOpenRedPacketResultStruct != null)
      {
        paramActivity = null;
        if (localOpenRedPacketResultStruct.amc)
        {
          paramActivity = new mdp();
          paramActivity.wording = localOpenRedPacketResultStruct.agk;
          paramActivity.nickName = localOpenRedPacketResultStruct.agj;
          paramActivity.avatarUrl = localOpenRedPacketResultStruct.agi;
        }
        this.jdField_a_of_type_Mek.a(localOpenRedPacketResultStruct.uP, localOpenRedPacketResultStruct.agh, paramActivity, localOpenRedPacketResultStruct.buttonWording, 2, j, 2);
      }
      QLog.i("RIJRedPacketPopupStep", 1, "launch from red packet tips click. share source: " + i + "\n packetId: " + str + "\n");
      localIntent.removeExtra("launch_from");
      localIntent.removeExtra("redpackid");
      bool1 = true;
    }
    label218:
    do
    {
      return bool1;
      bool1 = bool2;
    } while (TextUtils.isEmpty(str));
    this.jdField_a_of_type_Mek.a(this);
    this.jdField_a_of_type_Mek.c(str, this.aNZ, this.aOa, this.aOb);
    localIntent.removeExtra("redpackid");
    return true;
  }
  
  public void O(int paramInt1, int paramInt2, int paramInt3)
  {
    QLog.d("RIJRedPacketPopupStep", 1, "showErrorRedPacketDialog");
    if ((isResumed()) && (BN()))
    {
      new meb((ViewGroup)this.activity.getWindow().getDecorView(), BaseApplicationImpl.getContext().getString(2131718430), BaseApplicationImpl.getContext().getString(2131718561), paramInt1, paramInt2, this.rowkey).show(false);
      nn(true);
    }
  }
  
  public void X(boolean paramBoolean1, boolean paramBoolean2)
  {
    QLog.d("RIJRedPacketPopupStep", 1, "haveWallet = " + paramBoolean1 + " hasOpen = " + paramBoolean2);
  }
  
  public void a(long paramLong, String paramString1, @Nullable mdp parammdp, String paramString2, int paramInt1, int paramInt2, int paramInt3)
  {
    QLog.d("RIJRedPacketPopupStep", 1, "showOpenRedPacketDialog, rowkey = " + this.rowkey);
    ViewGroup localViewGroup;
    if (BN())
    {
      localViewGroup = (ViewGroup)this.activity.getWindow().getDecorView();
      if (parammdp != null) {
        break label90;
      }
    }
    label90:
    for (paramString1 = new mdz(localViewGroup, paramLong, paramString2, paramString1, paramInt1, paramInt2, paramInt3, this.rowkey);; paramString1 = new med(localViewGroup, paramLong, paramString1, parammdp, paramString2, paramInt1, paramInt2, paramInt3, this.rowkey))
    {
      paramString1.show(false);
      nn(true);
      return;
    }
  }
  
  public void a(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, String paramString3)
  {
    QLog.d("RIJRedPacketPopupStep", 1, "showRedPacketDialog, rowkey = " + paramString3);
    if ((isResumed()) && (BN()) && ((this.jdField_a_of_type_Mdw == null) || (!this.jdField_a_of_type_Mdw.isShowing())))
    {
      this.jdField_a_of_type_Mdw = new mdw((ViewGroup)this.activity.getWindow().getDecorView(), paramString1, paramString2, this.jdField_a_of_type_Mek, paramInt1, paramInt2, paramInt3, paramString3);
      this.jdField_a_of_type_Mdw.show();
    }
    nn(true);
  }
  
  public void aKm()
  {
    super.aKm();
    this.jdField_a_of_type_Mek.detachView();
    if (this.jdField_a_of_type_Mdw != null)
    {
      this.jdField_a_of_type_Mdw.dismiss();
      this.jdField_a_of_type_Mdw = null;
    }
  }
  
  protected void aKn()
  {
    QLog.d("RIJRedPacketPopupStep", 1, "doStepFromOnResume");
    nn(this.aju);
  }
  
  protected void aKo()
  {
    QLog.d("RIJRedPacketPopupStep", 1, "doStepFromOnShowSelf");
    if ((BN()) && (this.activity != null))
    {
      if ((m(this.activity)) || (l(this.activity))) {
        this.aju = true;
      }
    }
    else {
      return;
    }
    nn(false);
    this.aju = false;
  }
  
  public void aKu()
  {
    QLog.d("RIJRedPacketPopupStep", 1, "dismissRedPacketDialog");
    if (this.jdField_a_of_type_Mdw != null) {
      this.jdField_a_of_type_Mdw.dismiss();
    }
  }
  
  public void aKv()
  {
    QLog.d("RIJRedPacketPopupStep", 1, "showOtherPopupView");
    nn(false);
  }
  
  public void b(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3)
  {
    QLog.d("RIJRedPacketPopupStep", 1, "showErrorRedPacketDialog, wording = " + paramString1);
    if ((isResumed()) && (BN()))
    {
      new meb((ViewGroup)this.activity.getWindow().getDecorView(), paramString1, paramString2, paramInt1, paramInt2, this.rowkey).show(false);
      nn(true);
    }
  }
  
  public void h(int paramInt1, int paramInt2, int paramInt3, @Nullable String paramString)
  {
    this.aNZ = paramInt1;
    this.aOa = paramInt2;
    this.aOb = paramInt3;
    this.rowkey = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     lcy
 * JD-Core Version:    0.7.0.1
 */