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
import com.tencent.widget.AdapterView;
import com.tencent.widget.XListView;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class vif
  extends vhk
  implements View.OnClickListener, bfpt
{
  private TextWatcher jdField_a_of_type_AndroidTextTextWatcher = new vii(this);
  View jdField_a_of_type_AndroidViewView;
  ViewStub jdField_a_of_type_AndroidViewViewStub;
  public EditText a;
  TextView jdField_a_of_type_AndroidWidgetTextView = null;
  XListView jdField_a_of_type_ComTencentWidgetXListView = null;
  WeakReference<vie> jdField_a_of_type_JavaLangRefWeakReference;
  ArrayList<TroopBarPOI> jdField_a_of_type_JavaUtilArrayList = null;
  tey jdField_a_of_type_Tey = tey.a();
  vrx jdField_a_of_type_Vrx = null;
  View b;
  View c;
  View d = null;
  View e = null;
  View f = null;
  View g = null;
  
  public vif(@NonNull vhm paramvhm)
  {
    super(paramvhm);
  }
  
  private void l()
  {
    ved.b("Q.qqstory.publish.edit.EditVideoPoiSearch", "requestPoiList");
    String str = this.jdField_a_of_type_AndroidWidgetEditText.getText().toString();
    this.jdField_a_of_type_Tey.a(str);
    if (TextUtils.isEmpty(str))
    {
      ved.c("Q.qqstory.publish.edit.EditVideoPoiSearch", "requestPoiList text is null ignore");
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      this.jdField_a_of_type_Vrx.notifyDataSetChanged();
      k();
      return;
    }
    tes localtes = (tes)tcz.a(9);
    ter localter = vyl.a(this.jdField_a_of_type_Vhm.a);
    if (localter != null) {
      localtes.a(localter, this.jdField_a_of_type_Tey, new vih(this, str));
    }
    if (this.jdField_a_of_type_Tey.b())
    {
      j();
      this.d.setVisibility(4);
      return;
    }
    this.d.setVisibility(0);
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidViewViewStub = ((ViewStub)a(2131373348));
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
    if ((paramObject instanceof vie)) {
      this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference((vie)paramObject);
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
    paramString = a().getString(2131699687, new Object[] { paramString });
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString);
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.d == null) {
      return;
    }
    TextView localTextView = (TextView)this.d.findViewById(2131375055);
    if (paramBoolean)
    {
      localTextView.setText(2131719806);
      return;
    }
    localTextView.setText(2131719801);
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
        this.jdField_a_of_type_Vhm.a(0);
        this.jdField_a_of_type_Vhm.a(3, this.jdField_a_of_type_JavaLangRefWeakReference.get());
        bfni.b(a().a());
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
      this.b = this.jdField_a_of_type_AndroidViewView.findViewById(2131371811);
      this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)this.jdField_a_of_type_AndroidViewView.findViewById(2131368215));
      this.c = this.jdField_a_of_type_AndroidViewView.findViewById(2131363863);
      this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)this.jdField_a_of_type_AndroidViewView.findViewById(2131371810));
      this.e = this.jdField_a_of_type_AndroidViewView.findViewById(2131371819);
      this.f = this.jdField_a_of_type_AndroidViewView.findViewById(2131375744);
      this.g = this.jdField_a_of_type_AndroidViewView.findViewById(2131375707);
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131375708));
      this.b.setOnClickListener(this);
      this.e.setOnClickListener(this);
      this.jdField_a_of_type_ComTencentWidgetXListView.setOnItemClickListener(this);
      this.jdField_a_of_type_Vrx = new vrx(a());
      this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
      this.jdField_a_of_type_Vrx.a(this.jdField_a_of_type_JavaUtilArrayList, null);
      this.jdField_a_of_type_ComTencentWidgetXListView.setEmptyView(this.e);
      this.jdField_a_of_type_ComTencentWidgetXListView.setOnScrollListener(new vig(this));
      i();
      this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_Vrx);
      this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(this.jdField_a_of_type_AndroidTextTextWatcher);
      this.c.setOnClickListener(this);
    }
  }
  
  protected void g()
  {
    if ((this.jdField_a_of_type_AndroidViewView != null) && (this.jdField_a_of_type_AndroidViewView.getVisibility() == 0)) {
      this.jdField_a_of_type_Vhm.a(0);
    }
    bfni.b(a().a());
  }
  
  protected void i()
  {
    if (this.d == null)
    {
      this.d = LayoutInflater.from(a()).inflate(2131559459, null);
      ImageView localImageView = (ImageView)this.d.findViewById(2131375053);
      TextView localTextView1 = (TextView)this.d.findViewById(2131375055);
      TextView localTextView2 = (TextView)this.d.findViewById(2131375062);
      ProgressBar localProgressBar = (ProgressBar)this.d.findViewById(2131375056);
      localTextView1.setTextColor(-8355712);
      localTextView1.setText(2131719801);
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
    default: 
      return;
    case 2131371811: 
    case 2131371819: 
      bfni.b(a().a());
      return;
    }
    b();
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (paramInt < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      paramAdapterView = (TroopBarPOI)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
      g();
      paramView = (vie)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (paramView != null) {
        paramView.a(paramAdapterView);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vif
 * JD-Core Version:    0.7.0.1
 */