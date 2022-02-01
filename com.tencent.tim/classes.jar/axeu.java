import android.app.Dialog;
import android.app.Fragment;
import android.app.FragmentManager;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.InputFilter;
import android.text.Spanned;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.common.app.AppInterface;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.qqlive.module.videoreport.inject.fragment.FragmentCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.ReportFragment;
import dov.com.qq.im.ae.gif.AEStoryGIFPreviewActivity;
import dov.com.qq.im.ae.gif.giftext.AEGIFOutlineTextView;
import dov.com.qq.im.ae.gif.giftext.fragment.AEGIFTextEditFragment.10;
import dov.com.qq.im.ae.gif.giftext.fragment.AEGIFTextEditFragment.4;
import dov.com.qq.im.ae.gif.giftext.fragment.AEGIFTextEditFragment.5;

public class axeu
  extends ReportFragment
{
  private float DY;
  private float DZ = 0.82F;
  private float Ea = 0.16F;
  private ImageView Ic;
  private RecyclerView L;
  private View Mv;
  private axeu.b jdField_a_of_type_Axeu$b;
  private AEStoryGIFPreviewActivity jdField_a_of_type_DovComQqImAeGifAEStoryGIFPreviewActivity;
  private axea b;
  private aqju bi;
  private axdn jdField_c_of_type_Axdn;
  axfk jdField_c_of_type_Axfk;
  private String cTZ;
  private boolean duo;
  private boolean duq;
  private int eEK;
  private ViewGroup fa;
  private Dialog k;
  private EditText mEditText;
  private String mTextContent;
  private RelativeLayout nT;
  private RelativeLayout nU;
  private float outlineWidth = 1.0F;
  
  private void Sa()
  {
    this.k = new ReportDialog(this.jdField_a_of_type_DovComQqImAeGifAEStoryGIFPreviewActivity, 2131756467);
    this.k.setCancelable(false);
    this.k.setCanceledOnTouchOutside(false);
    this.k.setContentView(2131559410);
    this.k.show();
  }
  
  private void Ye(boolean paramBoolean)
  {
    String str = this.mEditText.getText().toString();
    if (paramBoolean)
    {
      if (str.equals(""))
      {
        if (this.jdField_c_of_type_Axdn != null) {
          this.jdField_c_of_type_Axdn.eIZ();
        }
        this.jdField_c_of_type_Axfk.clearText();
        jM("none", this.b.getTextColor());
        getFragmentManager().popBackStack();
        return;
      }
      Sa();
      act(str);
      return;
    }
    getFragmentManager().popBackStack();
  }
  
  public static axeu a(String paramString, boolean paramBoolean)
  {
    axeu localaxeu = new axeu();
    Bundle localBundle = new Bundle();
    localBundle.putString("KEY_PNG_DIR_PATH", paramString);
    localBundle.putBoolean("KEY_IS_MULTIPLE", paramBoolean);
    localaxeu.setArguments(localBundle);
    return localaxeu;
  }
  
  public static axeu a(String paramString, boolean paramBoolean, View paramView)
  {
    paramString = a(paramString, paramBoolean);
    paramString.dX(paramView);
    return paramString;
  }
  
  private void a(axeu.b paramb)
  {
    this.jdField_a_of_type_Axeu$b = paramb;
  }
  
  private void aI(View paramView, int paramInt)
  {
    if (paramView == null) {
      return;
    }
    ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)paramView.getLayoutParams();
    localMarginLayoutParams.topMargin = paramInt;
    paramView.setLayoutParams(localMarginLayoutParams);
  }
  
  private void aLz()
  {
    ((InputMethodManager)this.jdField_a_of_type_DovComQqImAeGifAEStoryGIFPreviewActivity.getSystemService("input_method")).hideSoftInputFromWindow(this.jdField_a_of_type_DovComQqImAeGifAEStoryGIFPreviewActivity.getWindow().getDecorView().getRootView().getWindowToken(), 0);
  }
  
  private void act(String paramString)
  {
    AppInterface localAppInterface = QQStoryContext.c();
    axbm localaxbm = (axbm)localAppInterface.getBusinessHandler(3);
    localAppInterface.addObserver(new axew(this, localAppInterface));
    localaxbm.acn(paramString);
  }
  
  private void biN()
  {
    this.jdField_c_of_type_Axfk = ((axfk)awuh.a(this.jdField_a_of_type_DovComQqImAeGifAEStoryGIFPreviewActivity).b(axfk.class));
  }
  
  private void cV(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1)
    {
      if (paramBoolean2)
      {
        eJi();
        Object localObject = (axfq.a)this.jdField_c_of_type_Axfk.o().getValue();
        if ((localObject != null) && (((axfq.a)localObject).cUd != null)) {
          aqhq.cn(((axfq.a)localObject).cUd);
        }
        localObject = new axfu(this.cTZ);
        eJf();
        String str = this.mEditText.getText().toString();
        ((axfu)localObject).a(str, 55, this.b.getTextColor(), this.b.getOutlineColor(), aqcx.dip2px(getActivity(), 4.0F), this.DY, this.DZ, this.outlineWidth, this.Ea);
        ((axfu)localObject).a(new axfa(this, str));
        return;
      }
      this.k.dismiss();
      this.jdField_a_of_type_DovComQqImAeGifAEStoryGIFPreviewActivity.runOnUiThread(new AEGIFTextEditFragment.4(this));
      return;
    }
    this.k.dismiss();
    eJh();
  }
  
  private void cW(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.k.dismiss();
    if (paramBoolean1)
    {
      if (paramBoolean2)
      {
        eJi();
        getFragmentManager().popBackStack();
        return;
      }
      this.jdField_a_of_type_DovComQqImAeGifAEStoryGIFPreviewActivity.runOnUiThread(new AEGIFTextEditFragment.5(this));
      return;
    }
    eJh();
  }
  
  private void dX(View paramView)
  {
    this.Mv = paramView;
  }
  
  private int e(char paramChar)
  {
    if ((paramChar == '\n') || (paramChar == '\r')) {
      return 0;
    }
    if (paramChar < '') {
      return 1;
    }
    return 2;
  }
  
  private void eJf()
  {
    if (((AEGIFOutlineTextView)this.Mv.findViewById(2131372763) != null) && (this.mEditText.getText().toString().indexOf('\n') > 0))
    {
      this.DZ = 0.73F;
      this.Ea = 0.3F;
    }
  }
  
  private void eJg()
  {
    ((InputMethodManager)this.jdField_a_of_type_DovComQqImAeGifAEStoryGIFPreviewActivity.getSystemService("input_method")).toggleSoftInput(1, 2);
  }
  
  private void eJh()
  {
    this.bi = aqha.a(this.jdField_a_of_type_DovComQqImAeGifAEStoryGIFPreviewActivity, 230);
    this.bi.setMessage(acfp.m(2131702143));
    this.bi.setCanceledOnTouchOutside(false);
    this.bi.setPositiveButton(acfp.m(2131702142), new axfb(this));
    this.bi.show();
  }
  
  private void eJi()
  {
    String str1 = this.mEditText.getText().toString();
    String str2 = this.b.getTextColor();
    int i = this.b.Rb();
    String str3 = this.b.getOutlineColor();
    if (this.jdField_c_of_type_Axdn != null) {
      this.jdField_a_of_type_DovComQqImAeGifAEStoryGIFPreviewActivity.runOnUiThread(new AEGIFTextEditFragment.10(this, str1, str2, str3, i));
    }
    this.jdField_c_of_type_Axfk.setText(str1, i);
    jM(str1, str2);
  }
  
  private void initViews()
  {
    this.nT = ((RelativeLayout)this.fa.findViewById(2131377377));
    this.nU = ((RelativeLayout)this.fa.findViewById(2131377473));
    this.Ic = ((ImageView)this.fa.findViewById(2131364026));
    this.L = ((RecyclerView)this.fa.findViewById(2131377611));
    LinearLayoutManager localLinearLayoutManager = new LinearLayoutManager(this.jdField_a_of_type_DovComQqImAeGifAEStoryGIFPreviewActivity, 0, false);
    this.L.setLayoutManager(localLinearLayoutManager);
    this.b = new axea(this.jdField_a_of_type_DovComQqImAeGifAEStoryGIFPreviewActivity, this.L);
    this.b.adL(this.eEK);
    this.L.setAdapter(this.b);
    this.fa.findViewById(2131379467).setOnClickListener(new axfc(this));
    this.fa.findViewById(2131379468).setOnClickListener(new axfd(this));
    this.Ic.setOnClickListener(new axfe(this));
  }
  
  private void jM(String paramString1, String paramString2)
  {
    axip.a().acX(paramString1);
    axip.a().setTextColor(paramString2);
  }
  
  public void a(axdn paramaxdn)
  {
    this.jdField_c_of_type_Axdn = paramaxdn;
  }
  
  public void acu(String paramString)
  {
    this.mEditText = ((EditText)this.fa.findViewById(2131378517));
    this.b.U(this.mEditText);
    this.mEditText.setText(this.mTextContent);
    this.mEditText.setTextColor(Color.parseColor(paramString));
    this.mEditText.setSelection(this.mTextContent.length());
    if ((this.mEditText.length() > 0) && (this.Ic != null)) {
      this.Ic.setVisibility(0);
    }
    this.mEditText.setFilters(new InputFilter[] { new axeu.a() });
    this.mEditText.addTextChangedListener(new axey(this));
  }
  
  public void d(View paramView1, View paramView2, View paramView3)
  {
    paramView1.getViewTreeObserver().addOnGlobalLayoutListener(new axex(this, paramView1, paramView3, paramView2));
  }
  
  protected int getLayoutId()
  {
    return 2131558629;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.cTZ = getArguments().getString("KEY_PNG_DIR_PATH");
    this.duq = getArguments().getBoolean("KEY_IS_MULTIPLE", false);
    this.jdField_a_of_type_DovComQqImAeGifAEStoryGIFPreviewActivity = ((AEStoryGIFPreviewActivity)getActivity());
    biN();
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.fa = ((ViewGroup)paramLayoutInflater.inflate(getLayoutId(), paramViewGroup, false));
    if (this.jdField_c_of_type_Axdn != null)
    {
      this.mTextContent = this.jdField_c_of_type_Axdn.HK();
      this.eEK = this.jdField_c_of_type_Axdn.Ra();
    }
    for (;;)
    {
      initViews();
      acu(this.b.getTextColor());
      eJg();
      paramLayoutInflater = this.fa;
      FragmentCollector.onFragmentViewCreated(this, paramLayoutInflater);
      return paramLayoutInflater;
      this.mTextContent = ((String)this.jdField_c_of_type_Axfk.n().getValue());
    }
  }
  
  public void onPause()
  {
    super.onPause();
    aLz();
  }
  
  public void onResume()
  {
    super.onResume();
    this.mEditText.requestFocus();
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    this.fa.setOnTouchListener(new axev(this));
    a(new axez(this));
    d(this.jdField_a_of_type_DovComQqImAeGifAEStoryGIFPreviewActivity.findViewById(2131377377), this.mEditText, this.nU);
  }
  
  class a
    implements InputFilter
  {
    private int mMax = 32;
    
    public a() {}
    
    public CharSequence filter(CharSequence paramCharSequence, int paramInt1, int paramInt2, Spanned paramSpanned, int paramInt3, int paramInt4)
    {
      if (paramCharSequence.equals("\n")) {
        return "";
      }
      for (;;)
      {
        char c;
        if ((paramInt1 <= this.mMax) && (paramInt2 < paramSpanned.length()))
        {
          c = paramSpanned.charAt(paramInt2);
          paramInt1 += axeu.a(axeu.this, c);
          paramInt2 += 1;
        }
        else
        {
          if (paramInt1 > this.mMax) {
            return paramSpanned.subSequence(0, paramInt2 - 1);
          }
          paramInt3 = 0;
          paramInt2 = paramInt1;
          paramInt1 = paramInt3;
          while ((paramInt2 <= this.mMax) && (paramInt1 < paramCharSequence.length()))
          {
            c = paramCharSequence.charAt(paramInt1);
            paramInt2 = axeu.a(axeu.this, c) + paramInt2;
            paramInt1 += 1;
          }
          paramInt3 = paramInt1;
          if (paramInt2 > this.mMax) {
            paramInt3 = paramInt1 - 1;
          }
          return paramCharSequence.subSequence(0, paramInt3);
          paramInt1 = 0;
          paramInt2 = 0;
        }
      }
    }
  }
  
  public static abstract interface b
  {
    public abstract void cX(boolean paramBoolean1, boolean paramBoolean2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     axeu
 * JD-Core Version:    0.7.0.1
 */