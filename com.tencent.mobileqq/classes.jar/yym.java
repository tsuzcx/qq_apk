import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.biz.qqstory.takevideo.EditVideoPoiSearch.1;
import com.tencent.mobileqq.troop.data.TroopBarPOI;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AdapterView;
import com.tencent.widget.XListView;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class yym
  extends yxr
  implements View.OnClickListener, bljm
{
  private TextWatcher jdField_a_of_type_AndroidTextTextWatcher = new yyp(this);
  View jdField_a_of_type_AndroidViewView;
  ViewStub jdField_a_of_type_AndroidViewViewStub;
  public EditText a;
  TextView jdField_a_of_type_AndroidWidgetTextView = null;
  XListView jdField_a_of_type_ComTencentWidgetXListView = null;
  WeakReference<yyl> jdField_a_of_type_JavaLangRefWeakReference;
  ArrayList<TroopBarPOI> jdField_a_of_type_JavaUtilArrayList = null;
  wvg jdField_a_of_type_Wvg = wvg.a();
  zie jdField_a_of_type_Zie = null;
  View b;
  View c;
  View d = null;
  View e = null;
  View f = null;
  View g = null;
  
  public yym(@NonNull yxt paramyxt)
  {
    super(paramyxt);
  }
  
  private void l()
  {
    yuk.b("Q.qqstory.publish.edit.EditVideoPoiSearch", "requestPoiList");
    String str = this.jdField_a_of_type_AndroidWidgetEditText.getText().toString();
    this.jdField_a_of_type_Wvg.a(str);
    if (TextUtils.isEmpty(str))
    {
      yuk.c("Q.qqstory.publish.edit.EditVideoPoiSearch", "requestPoiList text is null ignore");
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      this.jdField_a_of_type_Zie.notifyDataSetChanged();
      k();
      return;
    }
    wva localwva = (wva)wth.a(9);
    wuz localwuz = zos.a(this.jdField_a_of_type_Yxt.a);
    if (localwuz != null) {
      localwva.a(localwuz, this.jdField_a_of_type_Wvg, new yyo(this, str));
    }
    if (this.jdField_a_of_type_Wvg.b())
    {
      j();
      this.d.setVisibility(4);
      return;
    }
    this.d.setVisibility(0);
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidViewViewStub = ((ViewStub)a(2131374687));
  }
  
  public void a(int paramInt, Object paramObject)
  {
    switch (paramInt)
    {
    default: 
      if ((this.jdField_a_of_type_AndroidViewView != null) && (this.jdField_a_of_type_AndroidViewView.getVisibility() == 0)) {
        this.jdField_a_of_type_AndroidViewView.setVisibility(4);
      }
      return;
    }
    if ((paramObject instanceof yyl)) {
      this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference((yyl)paramObject);
    }
    f();
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetEditText.setText("");
    this.jdField_a_of_type_AndroidWidgetEditText.post(new EditVideoPoiSearch.1(this));
    this.d.setVisibility(4);
  }
  
  void a(String paramString)
  {
    this.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(0);
    this.e.setVisibility(0);
    this.f.setVisibility(4);
    this.g.setVisibility(0);
    paramString = a().getString(2131698600, new Object[] { paramString });
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString);
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.d == null) {
      return;
    }
    TextView localTextView = (TextView)this.d.findViewById(2131376444);
    if (paramBoolean)
    {
      localTextView.setText(2131718369);
      return;
    }
    localTextView.setText(2131718364);
  }
  
  public boolean a()
  {
    return b();
  }
  
  protected boolean b()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.jdField_a_of_type_AndroidViewView != null)
    {
      bool1 = bool2;
      if (this.jdField_a_of_type_AndroidViewView.getVisibility() == 0)
      {
        this.jdField_a_of_type_Yxt.a(0);
        this.jdField_a_of_type_Yxt.a(3, this.jdField_a_of_type_JavaLangRefWeakReference.get());
        blgx.b(a().a());
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_AndroidWidgetEditText != null) {
      this.jdField_a_of_type_AndroidWidgetEditText.removeTextChangedListener(this.jdField_a_of_type_AndroidTextTextWatcher);
    }
  }
  
  void f()
  {
    if (this.jdField_a_of_type_AndroidViewView == null)
    {
      this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewViewStub.inflate();
      this.b = this.jdField_a_of_type_AndroidViewView.findViewById(2131372839);
      this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)this.jdField_a_of_type_AndroidViewView.findViewById(2131368754));
      this.c = this.jdField_a_of_type_AndroidViewView.findViewById(2131364166);
      this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)this.jdField_a_of_type_AndroidViewView.findViewById(2131372838));
      this.e = this.jdField_a_of_type_AndroidViewView.findViewById(2131372847);
      this.f = this.jdField_a_of_type_AndroidViewView.findViewById(2131377212);
      this.g = this.jdField_a_of_type_AndroidViewView.findViewById(2131377169);
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131377170));
      this.b.setOnClickListener(this);
      this.e.setOnClickListener(this);
      this.jdField_a_of_type_ComTencentWidgetXListView.setOnItemClickListener(this);
      this.jdField_a_of_type_Zie = new zie(a());
      this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
      this.jdField_a_of_type_Zie.a(this.jdField_a_of_type_JavaUtilArrayList, null);
      this.jdField_a_of_type_ComTencentWidgetXListView.setEmptyView(this.e);
      this.jdField_a_of_type_ComTencentWidgetXListView.setOnScrollListener(new yyn(this));
      i();
      this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_Zie);
      this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(this.jdField_a_of_type_AndroidTextTextWatcher);
      this.c.setOnClickListener(this);
    }
  }
  
  protected void g()
  {
    if ((this.jdField_a_of_type_AndroidViewView != null) && (this.jdField_a_of_type_AndroidViewView.getVisibility() == 0)) {
      this.jdField_a_of_type_Yxt.a(0);
    }
    blgx.b(a().a());
  }
  
  protected void i()
  {
    if (this.d == null)
    {
      this.d = LayoutInflater.from(a()).inflate(2131559652, null);
      ImageView localImageView = (ImageView)this.d.findViewById(2131376442);
      TextView localTextView1 = (TextView)this.d.findViewById(2131376444);
      TextView localTextView2 = (TextView)this.d.findViewById(2131376450);
      ProgressBar localProgressBar = (ProgressBar)this.d.findViewById(2131376445);
      localTextView1.setTextColor(-8355712);
      localTextView1.setText(2131718364);
      localTextView2.setVisibility(8);
      localImageView.setVisibility(8);
      localProgressBar.setVisibility(8);
    }
    if (this.jdField_a_of_type_ComTencentWidgetXListView.getFooterViewsCount() > 0) {
      this.jdField_a_of_type_ComTencentWidgetXListView.removeFooterView(this.d);
    }
    this.jdField_a_of_type_ComTencentWidgetXListView.addFooterView(this.d);
  }
  
  void j()
  {
    this.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(4);
    this.e.setVisibility(0);
    this.f.setVisibility(0);
    this.g.setVisibility(4);
  }
  
  void k()
  {
    this.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(8);
    this.e.setVisibility(8);
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
      blgx.b(a().a());
      continue;
      b();
    }
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (paramInt < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      paramAdapterView = (TroopBarPOI)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
      g();
      paramView = (yyl)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (paramView != null) {
        paramView.a(paramAdapterView);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yym
 * JD-Core Version:    0.7.0.1
 */