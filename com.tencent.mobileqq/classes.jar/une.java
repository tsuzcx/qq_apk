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
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.ProteusInnerData;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.lang.ref.WeakReference;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONObject;

public class une
  extends ViewBase
  implements View.OnClickListener, View.OnFocusChangeListener
{
  private View jdField_a_of_type_AndroidViewView;
  private EditText jdField_a_of_type_AndroidWidgetEditText;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private ProteusInnerData jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdDataProteusInnerData;
  private String jdField_a_of_type_JavaLangString;
  private WeakReference<Context> jdField_a_of_type_JavaLangRefWeakReference;
  boolean jdField_a_of_type_Boolean = false;
  private String b;
  private String c;
  
  public une(VafContext paramVafContext)
  {
    super(paramVafContext);
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramVafContext.getContext());
    a();
  }
  
  private void a()
  {
    if ((this.jdField_a_of_type_JavaLangRefWeakReference != null) && (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null))
    {
      this.jdField_a_of_type_AndroidViewView = ((LayoutInflater)((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getSystemService("layout_inflater")).inflate(2131560097, null);
      this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)this.jdField_a_of_type_AndroidViewView.findViewById(2131366284));
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131380177));
      this.jdField_a_of_type_AndroidWidgetEditText.setOnFocusChangeListener(this);
      this.jdField_a_of_type_AndroidWidgetEditText.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    }
  }
  
  private void b()
  {
    Object localObject2 = null;
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdDataProteusInnerData.a != null)
    {
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdDataProteusInnerData.a.b)) {
        this.jdField_a_of_type_AndroidWidgetEditText.setHint(ukp.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdDataProteusInnerData.a.b, 32));
      }
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdDataProteusInnerData.a.c)) {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(ukp.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdDataProteusInnerData.a.c, 8));
      }
    }
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdDataProteusInnerData.E))
    {
      localObject1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdDataProteusInnerData.E;
      this.jdField_a_of_type_JavaLangString = ((String)localObject1);
      if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdDataProteusInnerData.G)) {
        break label174;
      }
    }
    label174:
    for (Object localObject1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdDataProteusInnerData.G;; localObject1 = null)
    {
      this.c = ((String)localObject1);
      localObject1 = localObject2;
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdDataProteusInnerData.H)) {
        localObject1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdDataProteusInnerData.H;
      }
      this.b = ((String)localObject1);
      return;
      localObject1 = null;
      break;
    }
  }
  
  public int getComMeasuredHeight()
  {
    return this.jdField_a_of_type_AndroidViewView.getMeasuredHeight();
  }
  
  public int getComMeasuredWidth()
  {
    return this.jdField_a_of_type_AndroidViewView.getMeasuredWidth();
  }
  
  public View getNativeView()
  {
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    String str1;
    do
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      str1 = this.jdField_a_of_type_AndroidWidgetEditText.getText().toString().trim();
    } while (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdDataProteusInnerData == null);
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdDataProteusInnerData.a != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdDataProteusInnerData.a.jdField_a_of_type_JavaUtilRegexPattern != null)) {}
    for (boolean bool = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdDataProteusInnerData.a.jdField_a_of_type_JavaUtilRegexPattern.matcher(str1).matches();; bool = true)
    {
      for (;;)
      {
        if (!bool) {
          break label173;
        }
        QQToast.a(paramView.getContext(), -1, anvx.a(2131712365), 0).b(((BaseActivity)paramView.getContext()).getTitleBarHeight());
        if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdDataProteusInnerData.a == null) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdDataProteusInnerData.a.jdField_a_of_type_OrgJsonJSONObject == null)) {
          break;
        }
        try
        {
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdDataProteusInnerData.a.jdField_a_of_type_OrgJsonJSONObject.put("value", str1);
        }
        catch (Exception localException) {}
      }
      break;
      label173:
      String str2 = anvx.a(2131712391);
      QQToast.a(paramView.getContext(), 1, str2, 0).b(((BaseActivity)paramView.getContext()).getTitleBarHeight());
      break;
    }
  }
  
  public void onComLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.jdField_a_of_type_AndroidViewView.layout(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void onComMeasure(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_AndroidViewView.measure(paramInt1, paramInt2);
  }
  
  public void onFocusChange(View paramView, boolean paramBoolean)
  {
    if ((paramBoolean) && (this.jdField_a_of_type_JavaLangRefWeakReference != null) && (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null) && ((this.jdField_a_of_type_JavaLangRefWeakReference.get() instanceof Activity))) {
      ((Activity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getWindow().getAttributes().softInputMode = 4;
    }
    if ((!this.jdField_a_of_type_Boolean) && (paramBoolean))
    {
      this.jdField_a_of_type_Boolean = true;
      ukp.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdDataProteusInnerData, 39);
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
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdDataProteusInnerData = ((ProteusInnerData)paramObject);
        b();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     une
 * JD-Core Version:    0.7.0.1
 */