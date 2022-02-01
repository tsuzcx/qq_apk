import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.Window;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.ad.data.ProteusInnerData;
import com.tencent.biz.pubaccount.readinjoy.ad.data.ProteusInnerData.a;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.IBuilder;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.lang.ref.WeakReference;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONObject;

public class koi
  extends ViewBase
  implements View.OnClickListener, View.OnFocusChangeListener
{
  private EditText P;
  private String abq;
  private String abr;
  private String abt;
  boolean agP = false;
  private ProteusInnerData c;
  private WeakReference<Context> mContext;
  private View mRootView;
  private TextView oy;
  
  public koi(VafContext paramVafContext)
  {
    super(paramVafContext);
    this.mContext = new WeakReference(paramVafContext.getContext());
    aFr();
  }
  
  private void aFr()
  {
    if ((this.mContext != null) && (this.mContext.get() != null))
    {
      this.mRootView = ((LayoutInflater)((Context)this.mContext.get()).getSystemService("layout_inflater")).inflate(2131560235, null);
      this.P = ((EditText)this.mRootView.findViewById(2131366545));
      this.oy = ((TextView)this.mRootView.findViewById(2131380946));
      this.P.setOnFocusChangeListener(this);
      this.P.setOnClickListener(this);
      this.oy.setOnClickListener(this);
    }
  }
  
  private void bindData()
  {
    Object localObject2 = null;
    if (this.c.a != null)
    {
      if (!TextUtils.isEmpty(this.c.a.aaY)) {
        this.P.setHint(knb.A(this.c.a.aaY, 32));
      }
      if (!TextUtils.isEmpty(this.c.a.aaZ)) {
        this.oy.setText(knb.A(this.c.a.aaZ, 8));
      }
    }
    if (!TextUtils.isEmpty(this.c.abq))
    {
      localObject1 = this.c.abq;
      this.abq = ((String)localObject1);
      if (TextUtils.isEmpty(this.c.abt)) {
        break label174;
      }
    }
    label174:
    for (Object localObject1 = this.c.abt;; localObject1 = null)
    {
      this.abt = ((String)localObject1);
      localObject1 = localObject2;
      if (!TextUtils.isEmpty(this.c.abr)) {
        localObject1 = this.c.abr;
      }
      this.abr = ((String)localObject1);
      return;
      localObject1 = null;
      break;
    }
  }
  
  public int getComMeasuredHeight()
  {
    return this.mRootView.getMeasuredHeight();
  }
  
  public int getComMeasuredWidth()
  {
    return this.mRootView.getMeasuredWidth();
  }
  
  public View getNativeView()
  {
    return this.mRootView;
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
      String str = this.P.getText().toString().trim();
      boolean bool2 = true;
      if (this.c != null)
      {
        boolean bool1 = bool2;
        if (this.c.a != null)
        {
          bool1 = bool2;
          if (this.c.a.I != null) {
            bool1 = this.c.a.I.matcher(str).matches();
          }
        }
        if ((bool1) && (this.c.a != null) && (this.c.a.jsonObject != null)) {
          try
          {
            this.c.a.jsonObject.put("value", str);
          }
          catch (Exception localException) {}
        }
      }
    }
  }
  
  public void onComLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.mRootView.layout(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void onComMeasure(int paramInt1, int paramInt2)
  {
    this.mRootView.measure(paramInt1, paramInt2);
  }
  
  public void onFocusChange(View paramView, boolean paramBoolean)
  {
    if ((paramBoolean) && (this.mContext != null) && (this.mContext.get() != null) && ((this.mContext.get() instanceof Activity))) {
      ((Activity)this.mContext.get()).getWindow().getAttributes().softInputMode = 4;
    }
    if ((!this.agP) && (paramBoolean))
    {
      this.agP = true;
      knb.a(this.c, 39);
    }
  }
  
  public boolean setAttribute(int paramInt, Object paramObject)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return super.setAttribute(paramInt, paramObject);
      if ((paramObject != null) && ((paramObject instanceof ProteusInnerData)))
      {
        this.c = ((ProteusInnerData)paramObject);
        bindData();
      }
    }
  }
  
  public static class a
    implements ViewBase.IBuilder
  {
    public ViewBase build(VafContext paramVafContext)
    {
      return new koi(paramVafContext);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     koi
 * JD-Core Version:    0.7.0.1
 */