import android.content.Intent;
import android.net.Uri;
import android.os.Handler.Callback;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.FriendProfilePhotoHelper.1;
import com.tencent.mobileqq.activity.FriendProfilePhotoHelper.2;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivity.b;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.CardHandler.a;
import com.tencent.mobileqq.app.CardHandler.b;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.profile.CustomCoverFragment;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.nio.ByteBuffer;
import java.util.ArrayList;

public class vbv
  implements CardHandler.b
{
  public static final String TAG = vbv.class.getSimpleName();
  Handler.Callback a;
  public CardHandler.a a;
  public vbv.a a;
  public boolean aXf;
  public QQAppInterface app;
  public auru b;
  public int bHA;
  public byte[] ca;
  public final BaseActivity mActivity;
  public String mCoverUrl;
  public Runnable mDismissRunnable = new FriendProfilePhotoHelper.2(this);
  public arhz r;
  public Uri y;
  
  public vbv(BaseActivity paramBaseActivity, vbv.a parama)
  {
    this.jdField_a_of_type_AndroidOsHandler$Callback = new vbw(this);
    this.mActivity = paramBaseActivity;
    this.jdField_a_of_type_Vbv$a = parama;
    this.app = this.mActivity.app;
    this.b = new auru(Looper.getMainLooper(), this.jdField_a_of_type_AndroidOsHandler$Callback);
    paramBaseActivity = (CardHandler)this.app.getBusinessHandler(2);
    if (paramBaseActivity != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppCardHandler$a = paramBaseActivity.a(this.app, this);
    }
  }
  
  public void D(int paramInt, Intent paramIntent)
  {
    if (!aqiw.isNetSupport(BaseApplication.getContext())) {
      this.jdField_a_of_type_Vbv$a.cf(2131696348, 1);
    }
    do
    {
      do
      {
        return;
      } while ((paramInt != -1) || (paramIntent == null));
      paramIntent = paramIntent.getStringArrayListExtra("key_cover_selected_img_path");
    } while ((paramIntent == null) || (paramIntent.size() <= 0));
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "pick photo from qzone size:" + paramIntent.size());
    }
    ((CardHandler)this.app.getBusinessHandler(2)).dy(paramIntent);
    bPq();
  }
  
  public void E(int paramInt, Intent paramIntent)
  {
    if (!aqiw.isNetSupport(BaseApplication.getContext())) {
      this.jdField_a_of_type_Vbv$a.cf(2131696348, 1);
    }
    label21:
    int i;
    do
    {
      do
      {
        do
        {
          do
          {
            ArrayList localArrayList;
            do
            {
              break label21;
              break label21;
              break label21;
              do
              {
                return;
              } while (paramIntent == null);
              i = paramIntent.getIntExtra("req_code_key", 0);
              if (i != 1025) {
                break;
              }
              localArrayList = paramIntent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS");
            } while ((localArrayList == null) || (localArrayList.size() <= 0));
            CardHandler localCardHandler = (CardHandler)this.app.getBusinessHandler(2);
            if (paramIntent.getBooleanExtra("action_cover_pick_gallery", false))
            {
              localCardHandler.Dt((String)localArrayList.get(0));
              bPq();
              this.b.postDelayed(this.mDismissRunnable, 30000L);
              return;
            }
            localCardHandler.dy(localArrayList);
            bPq();
            return;
            if (i != 1020) {
              break;
            }
          } while ((paramInt != -1) || (paramIntent == null));
          paramIntent = paramIntent.getStringExtra("key_cover_selected_img_path");
        } while (TextUtils.isEmpty(paramIntent));
        vK(paramIntent);
        return;
        if (i != 1021) {
          break;
        }
      } while (paramInt != -1);
      this.y = ((Uri)paramIntent.getParcelableExtra("upload_uri_key"));
      vK(aqhu.getRealPathFromContentURI(this.mActivity, this.y));
      return;
    } while ((i != 2002) || (paramInt != -1));
    paramIntent = alco.E(paramIntent.getStringExtra("card_url_key"));
    this.jdField_a_of_type_Vbv$a.ai(paramIntent);
  }
  
  public void a(Intent paramIntent, ArrayList<String> paramArrayList)
  {
    if (paramIntent.getBooleanExtra("action_cover_pick_gallery", false))
    {
      cQ(paramArrayList);
      return;
    }
    cP(paramArrayList);
  }
  
  public void ak(byte[] paramArrayOfByte)
  {
    this.ca = paramArrayOfByte;
    this.aXf = true;
    ThreadManager.excute(new FriendProfilePhotoHelper.1(this), 16, null, false);
  }
  
  public void al(byte[] paramArrayOfByte)
  {
    int k = 0;
    this.b.removeCallbacks(this.mDismissRunnable);
    bPr();
    this.jdField_a_of_type_Vbv$a.cf(2131721595, 2);
    if (paramArrayOfByte != null)
    {
      Object localObject = ByteBuffer.wrap(paramArrayOfByte);
      int j = ((ByteBuffer)localObject).get();
      if (j != 0) {
        if (QLog.isColorLevel()) {
          QLog.d(TAG, 2, "error retCode:" + j);
        }
      }
      do
      {
        return;
        byte[] arrayOfByte1 = new byte[4];
        byte[] arrayOfByte2 = new byte[4];
        j = 0;
        while (j < 4)
        {
          int i = ((ByteBuffer)localObject).get();
          arrayOfByte1[j] = i;
          arrayOfByte2[(3 - j)] = i;
          j += 1;
        }
        int m = (int)aprd.d(arrayOfByte1);
        if (m <= paramArrayOfByte.length - 5)
        {
          j = m;
          if (m >= 0) {}
        }
        else
        {
          j = (int)aprd.d(arrayOfByte2);
        }
        if (QLog.isColorLevel()) {
          QLog.d(TAG, 2, "len:" + j + " bLength:" + aqhs.bytes2HexStr(arrayOfByte1) + " bFlipLength:" + aqhs.bytes2HexStr(arrayOfByte2));
        }
        if ((j <= paramArrayOfByte.length - 5) && (j >= 0)) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d(TAG, 2, "长度超出! len:" + j + " extraInfo.length:" + paramArrayOfByte.length);
      return;
      localObject = new byte[j];
      while (k < j)
      {
        localObject[k] = paramArrayOfByte[(k + 5)];
        k += 1;
      }
      this.jdField_a_of_type_Vbv$a.aj((byte[])localObject);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "send finish extraInfo is null");
    }
    this.jdField_a_of_type_Vbv$a.aj(null);
  }
  
  protected void bPq()
  {
    try
    {
      if (!this.mActivity.isFinishing())
      {
        this.r = new arhz(this.mActivity, this.mActivity.getTitleBarHeight());
        this.r.setCancelable(false);
        this.r.setMessage(2131691470);
        this.r.show();
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void bPr()
  {
    if ((this.r != null) && (this.r.isShowing())) {}
    try
    {
      this.r.dismiss();
      this.r = null;
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
  }
  
  public void bPs()
  {
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, String.format("onSendFailed activity=%s", new Object[] { this }));
    }
    this.b.removeCallbacks(this.mDismissRunnable);
    bPr();
    this.jdField_a_of_type_Vbv$a.cf(2131721598, 1);
  }
  
  public void cP(ArrayList<String> paramArrayList)
  {
    if (!aqiw.isNetSupport(BaseApplication.getContext()))
    {
      this.jdField_a_of_type_Vbv$a.cf(2131696348, 1);
      return;
    }
    ((CardHandler)this.app.getBusinessHandler(2)).dy(paramArrayList);
    bPq();
  }
  
  public void cQ(ArrayList<String> paramArrayList)
  {
    if (!aqiw.isNetSupport(BaseApplication.getContext()))
    {
      this.jdField_a_of_type_Vbv$a.cf(2131696348, 1);
      return;
    }
    ((CardHandler)this.app.getBusinessHandler(2)).Dt((String)paramArrayList.get(0));
    bPq();
    this.b.postDelayed(this.mDismissRunnable, 30000L);
  }
  
  public void d(Card paramCard)
  {
    if (paramCard != null)
    {
      paramCard = paramCard.getCoverData(this.bHA);
      String str = (String)paramCard[0];
      if ((!TextUtils.isEmpty(str)) && (!str.equals(this.mCoverUrl)))
      {
        this.mCoverUrl = str;
        this.bHA = ((Integer)paramCard[1]).intValue();
      }
    }
  }
  
  public void destroy()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppCardHandler$a != null)
    {
      ((CardHandler)this.app.getBusinessHandler(2)).a(this.jdField_a_of_type_ComTencentMobileqqAppCardHandler$a);
      this.jdField_a_of_type_ComTencentMobileqqAppCardHandler$a = null;
    }
    this.aXf = false;
    this.ca = null;
    this.mCoverUrl = "";
    this.bHA = 0;
  }
  
  protected void vK(String paramString)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("Business_Origin", 101);
    localIntent.putExtra("action_cover_pick_gallery", true);
    localIntent.putExtra("PhotoConst.32_Bit_Config", true);
    PhotoUtils.a(localIntent, this.mActivity, this.mActivity.getClass().getName(), aqep.x(this.mActivity), aqep.y(this.mActivity), aqep.x(this.mActivity), aqep.y(this.mActivity), paramString, aqep.BT());
  }
  
  public void xr(boolean paramBoolean)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("is_default_key", paramBoolean);
    PublicFragmentActivity.b.startForResult(this.mActivity, localIntent, PublicFragmentActivity.class, CustomCoverFragment.class, 1024);
  }
  
  public static abstract interface a
  {
    public abstract void ai(byte[] paramArrayOfByte);
    
    public abstract void aj(byte[] paramArrayOfByte);
    
    public abstract void cf(int paramInt1, int paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vbv
 * JD-Core Version:    0.7.0.1
 */