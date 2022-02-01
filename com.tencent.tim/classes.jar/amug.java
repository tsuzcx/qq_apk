import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.item.ArkAppRootLayout;
import com.tencent.mobileqq.search.rich.ArkAppView;
import com.tencent.mobileqq.search.rich.ArkAppView.a;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class amug
  extends amuu
  implements ArkAppView.a
{
  private ArkAppView a;
  private boolean cEk = true;
  private LinearLayout fc;
  private WeakReference<amuj> hP;
  private boolean mLoadFailed;
  private View mRootView;
  
  public amug(amuk paramamuk, Context paramContext)
  {
    super(paramamuk, paramContext);
  }
  
  public void UC(int paramInt)
  {
    if (this.hP == null) {}
    amuj localamuj;
    do
    {
      return;
      localamuj = (amuj)this.hP.get();
    } while (localamuj == null);
    localamuj.onLoadResult(paramInt);
  }
  
  public void a(amuf paramamuf)
  {
    if ((this.a == null) || (paramamuf == null)) {
      return;
    }
    this.a.a(paramamuf, this);
  }
  
  public void a(amuj paramamuj)
  {
    this.hP = new WeakReference(paramamuj);
  }
  
  public View cs()
  {
    return this.a;
  }
  
  public View n(Context paramContext)
  {
    paramContext = LayoutInflater.from(paramContext).inflate(2131561649, null, false);
    this.mRootView = paramContext;
    this.a = ((ArkAppView)this.mRootView.findViewById(2131362965));
    this.fc = null;
    ((ArkAppRootLayout)paramContext).setDisableParentReturn(false);
    return this.mRootView;
  }
  
  public void onDestroy()
  {
    this.mRootView = null;
    if (this.a != null)
    {
      this.a.unInit();
      this.a = null;
    }
    this.fc = null;
    super.onDestroy();
  }
  
  public void onFirstFrame() {}
  
  public void onLoadFailed(String paramString, int paramInt, boolean paramBoolean)
  {
    this.mLoadFailed = true;
    UC(1);
    if (this.fc == null) {}
    TextView localTextView;
    label124:
    do
    {
      return;
      if (this.cEk)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ArkNodeView", 2, "onLoadFailed, show no result");
        }
        this.mRootView.setVisibility(8);
        showDivider(false);
        return;
      }
      this.fc.setVisibility(0);
      if (!paramBoolean) {
        break;
      }
      this.fc.setOnClickListener(new amuh(this));
      localTextView = (TextView)this.fc.findViewById(2131377042);
      if (localTextView != null)
      {
        if (paramString != null) {
          break label169;
        }
        localTextView.setText(this.fc.getContext().getResources().getString(2131690522));
      }
      paramString = this.fc.findViewById(2131377034);
    } while (paramString == null);
    if (paramBoolean) {}
    for (paramInt = 2130838756;; paramInt = 2130838755)
    {
      paramString.setBackgroundDrawable(paramString.getResources().getDrawable(paramInt));
      return;
      this.fc.setOnClickListener(null);
      break;
      label169:
      localTextView.setText(paramString);
      break label124;
    }
  }
  
  public void onLoadSuccess()
  {
    this.mLoadFailed = false;
    UC(1);
    if (this.mRootView != null) {
      this.mRootView.setVisibility(0);
    }
    if (this.fc != null) {
      this.fc.setVisibility(8);
    }
  }
  
  public void onLoading()
  {
    if (this.fc != null) {
      this.fc.setVisibility(0);
    }
  }
  
  public void showDivider(boolean paramBoolean)
  {
    boolean bool = paramBoolean;
    if (paramBoolean)
    {
      bool = paramBoolean;
      if (this.mLoadFailed)
      {
        bool = paramBoolean;
        if (this.cEk) {
          bool = false;
        }
      }
    }
    super.showDivider(bool);
  }
  
  public void update() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amug
 * JD-Core Version:    0.7.0.1
 */