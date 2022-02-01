import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.TextureView;
import android.view.View;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.richmediabrowser.view.AIOBrowserScene.1;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.richmediabrowser.model.RichMediaBaseData;
import com.tencent.richmediabrowser.model.RichMediaBrowserInfo;
import com.tencent.richmediabrowser.view.MainBrowserScene;
import com.tencent.richmediabrowser.view.page.DragView;

public class amdq
  extends MainBrowserScene
{
  public TextureView b;
  private amcv c;
  private RelativeLayout contentView;
  private Handler mHandler;
  private View rootView;
  
  public amdq(Activity paramActivity, amcv paramamcv)
  {
    super(paramActivity, paramamcv);
    this.mActivity = paramActivity;
    this.c = paramamcv;
    super.setPresenter(this.c);
  }
  
  public void OL(boolean paramBoolean)
  {
    TextureView localTextureView;
    if (this.b != null)
    {
      localTextureView = this.b;
      if (!paramBoolean) {
        break label24;
      }
    }
    label24:
    for (int i = 0;; i = 8)
    {
      localTextureView.setVisibility(i);
      return;
    }
  }
  
  public boolean avI()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.b != null)
    {
      bool1 = bool2;
      if (this.b.getVisibility() == 0) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public boolean back()
  {
    OL(false);
    return super.back();
  }
  
  public void buildParams(Intent paramIntent)
  {
    super.buildParams(paramIntent);
    this.mHandler = new Handler(Looper.getMainLooper());
  }
  
  public void dMQ()
  {
    if (this.mHandler != null) {
      this.mHandler.postDelayed(new AIOBrowserScene.1(this), 1000L);
    }
  }
  
  public RelativeLayout getContentView()
  {
    return this.contentView;
  }
  
  public void initView()
  {
    super.initView();
    this.mDragView.setOriginRect(amcj.a().getThumbRect());
    this.rootView = LayoutInflater.from(this.mContext).inflate(2131558639, null);
    if (amch.avy()) {
      this.b = ((TextureView)this.rootView.findViewById(2131365578));
    }
    this.contentView = ((RelativeLayout)this.rootView.findViewById(2131363729));
    super.getContentView().addView(this.rootView);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == 19002)
    {
      if (paramInt2 == -1) {
        this.mContext.setResult(-1, paramIntent);
      }
      this.mContext.finish();
    }
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                return;
                if (paramInt1 != 19000) {
                  break;
                }
              } while (paramInt2 != -1);
              return;
              if (paramInt1 != 19005) {
                break;
              }
            } while (paramInt2 != -1);
            paramIntent = getCurrentView();
          } while (!(paramIntent instanceof amdo));
          ((amdo)paramIntent).dMJ();
          return;
        } while (paramInt1 == 103);
        super.onActivityResult(paramInt1, paramInt2, paramIntent);
        if ((paramInt2 != -1) || (paramInt1 != 0)) {
          break;
        }
        amdl.l(this.mContext, paramIntent.getExtras());
      } while (amcj.a().Iz() != 9501);
      this.mContext.finish();
      return;
    } while ((paramInt2 != -1) || (paramInt1 != 10001));
    QQToast.a(this.mContext, 2131720247, 0).show();
  }
  
  public void onContentMove(float paramFloat)
  {
    super.onContentMove(paramFloat);
    this.c.OK(false);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.mHandler != null) {
      this.mHandler.removeCallbacksAndMessages(null);
    }
    if (this.contentView != null) {
      this.contentView.removeAllViews();
    }
  }
  
  public void onGestureFinish()
  {
    Object localObject = this.c.b.getSelectedItem();
    if ((localObject != null) && (((RichMediaBrowserInfo)localObject).baseData != null)) {
      if (((RichMediaBrowserInfo)localObject).baseData.getType() == 100) {
        localObject = "0X8009AB2";
      }
    }
    for (;;)
    {
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        anot.a(null, "dc00898", "", "", (String)localObject, (String)localObject, amcj.a().IB(), 0, "", "", "", "");
      }
      this.c.dMH();
      super.onGestureFinish();
      return;
      if (((RichMediaBrowserInfo)localObject).baseData.getType() == 101) {
        localObject = "0X8009AB3";
      } else {
        localObject = null;
      }
    }
  }
  
  public void onPause()
  {
    super.onPause();
    if (this.c.le(this.c.getCurrentPosition())) {
      this.c.OK(true);
    }
  }
  
  public void onResetPosition()
  {
    if (amcj.a().IB() == 4) {
      return;
    }
    super.onResetPosition();
    this.c.cWC();
  }
  
  public void onResume()
  {
    super.onResume();
    if (this.c.le(this.c.getCurrentPosition())) {
      this.c.cWC();
    }
  }
  
  public void showContentView(boolean paramBoolean)
  {
    RelativeLayout localRelativeLayout;
    if (this.contentView != null)
    {
      localRelativeLayout = this.contentView;
      if (!paramBoolean) {
        break label24;
      }
    }
    label24:
    for (int i = 0;; i = 8)
    {
      localRelativeLayout.setVisibility(i);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amdq
 * JD-Core Version:    0.7.0.1
 */