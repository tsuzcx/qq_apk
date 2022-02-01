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
import com.tencent.widget.AdapterView.c;
import com.tencent.widget.XListView;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class rdv
  extends rdb
  implements View.OnClickListener, AdapterView.c
{
  rkk a = null;
  public EditText af;
  pub.d b;
  WeakReference<rdu> dc;
  private TextWatcher jdField_i_of_type_AndroidTextTextWatcher = new rdy(this);
  XListView jdField_i_of_type_ComTencentWidgetXListView = null;
  View mRootView;
  ViewStub n;
  ArrayList<TroopBarPOI> nw = null;
  View oM = null;
  View oN;
  View oO;
  View oP = null;
  View oQ = null;
  View oR = null;
  TextView yr = null;
  
  public rdv(@NonNull rdc paramrdc)
  {
    super(paramrdc);
    this.jdField_b_of_type_Pub$d = pub.d.a();
  }
  
  private void btk()
  {
    ram.d("Q.qqstory.publish.edit.EditVideoPoiSearch", "requestPoiList");
    String str = this.af.getText().toString();
    this.jdField_b_of_type_Pub$d.rq(str);
    if (TextUtils.isEmpty(str))
    {
      ram.i("Q.qqstory.publish.edit.EditVideoPoiSearch", "requestPoiList text is null ignore");
      this.nw.clear();
      this.a.notifyDataSetChanged();
      btr();
      return;
    }
    pub localpub = (pub)psx.a(9);
    pua localpua = rpb.a(this.jdField_b_of_type_Rdc.a);
    if (localpua != null) {
      localpub.a(localpua, this.jdField_b_of_type_Pub$d, new rdx(this, str));
    }
    if (this.jdField_b_of_type_Pub$d.IZ())
    {
      btq();
      this.oM.setVisibility(4);
      return;
    }
    this.oM.setVisibility(0);
  }
  
  protected boolean Lk()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.mRootView != null)
    {
      bool1 = bool2;
      if (this.mRootView.getVisibility() == 0)
      {
        this.jdField_b_of_type_Rdc.changeState(0);
        this.jdField_b_of_type_Rdc.r(3, this.dc.get());
        aurd.hide(a().getRootView());
        bool1 = true;
      }
    }
    return bool1;
  }
  
  void bsQ()
  {
    if (this.mRootView == null)
    {
      this.mRootView = this.n.inflate();
      this.oN = this.mRootView.findViewById(2131373456);
      this.af = ((EditText)this.mRootView.findViewById(2131369305));
      this.oO = this.mRootView.findViewById(2131364236);
      this.jdField_i_of_type_ComTencentWidgetXListView = ((XListView)this.mRootView.findViewById(2131373455));
      this.oP = this.mRootView.findViewById(2131373464);
      this.oQ = this.mRootView.findViewById(2131377869);
      this.oR = this.mRootView.findViewById(2131377819);
      this.yr = ((TextView)this.mRootView.findViewById(2131377820));
      this.oN.setOnClickListener(this);
      this.oP.setOnClickListener(this);
      this.jdField_i_of_type_ComTencentWidgetXListView.setOnItemClickListener(this);
      this.a = new rkk(getContext());
      this.nw = new ArrayList();
      this.a.a(this.nw, null);
      this.jdField_i_of_type_ComTencentWidgetXListView.setEmptyView(this.oP);
      this.jdField_i_of_type_ComTencentWidgetXListView.setOnScrollListener(new rdw(this));
      btp();
      this.jdField_i_of_type_ComTencentWidgetXListView.setAdapter(this.a);
      this.af.addTextChangedListener(this.jdField_i_of_type_AndroidTextTextWatcher);
      this.oO.setOnClickListener(this);
    }
  }
  
  protected void bto()
  {
    if ((this.mRootView != null) && (this.mRootView.getVisibility() == 0)) {
      this.jdField_b_of_type_Rdc.changeState(0);
    }
    aurd.hide(a().getRootView());
  }
  
  protected void btp()
  {
    if (this.oM == null)
    {
      this.oM = LayoutInflater.from(getContext()).inflate(2131559847, null);
      ImageView localImageView = (ImageView)this.oM.findViewById(2131377034);
      TextView localTextView1 = (TextView)this.oM.findViewById(2131377036);
      TextView localTextView2 = (TextView)this.oM.findViewById(2131377043);
      ProgressBar localProgressBar = (ProgressBar)this.oM.findViewById(2131377037);
      localTextView1.setTextColor(-8355712);
      localTextView1.setText(2131720482);
      localTextView2.setVisibility(8);
      localImageView.setVisibility(8);
      localProgressBar.setVisibility(8);
    }
    if (this.jdField_i_of_type_ComTencentWidgetXListView.getFooterViewsCount() > 0) {
      this.jdField_i_of_type_ComTencentWidgetXListView.removeFooterView(this.oM);
    }
    this.jdField_i_of_type_ComTencentWidgetXListView.addFooterView(this.oM);
  }
  
  void btq()
  {
    this.jdField_i_of_type_ComTencentWidgetXListView.setVisibility(4);
    this.oP.setVisibility(0);
    this.oQ.setVisibility(0);
    this.oR.setVisibility(4);
  }
  
  void btr()
  {
    this.jdField_i_of_type_ComTencentWidgetXListView.setVisibility(8);
    this.oP.setVisibility(8);
  }
  
  public boolean onBackPressed()
  {
    return Lk();
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
      aurd.hide(a().getRootView());
      continue;
      Lk();
    }
  }
  
  public void onCreate()
  {
    this.n = ((ViewStub)y(2131375230));
  }
  
  public void onDestroy()
  {
    if (this.af != null) {
      this.af.removeTextChangedListener(this.jdField_i_of_type_AndroidTextTextWatcher);
    }
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (paramInt < this.nw.size())
    {
      paramAdapterView = (TroopBarPOI)this.nw.get(paramInt);
      bto();
      paramView = (rdu)this.dc.get();
      if (paramView != null) {
        paramView.a(paramAdapterView);
      }
    }
  }
  
  public void p(int paramInt, Object paramObject)
  {
    switch (paramInt)
    {
    default: 
      if ((this.mRootView != null) && (this.mRootView.getVisibility() == 0)) {
        this.mRootView.setVisibility(4);
      }
      return;
    }
    if ((paramObject instanceof rdu)) {
      this.dc = new WeakReference((rdu)paramObject);
    }
    bsQ();
    this.mRootView.setVisibility(0);
    this.af.setText("");
    this.af.post(new EditVideoPoiSearch.1(this));
    this.oM.setVisibility(4);
  }
  
  void su(String paramString)
  {
    this.jdField_i_of_type_ComTencentWidgetXListView.setVisibility(0);
    this.oP.setVisibility(0);
    this.oQ.setVisibility(4);
    this.oR.setVisibility(0);
    paramString = getResources().getString(2131701927, new Object[] { paramString });
    this.yr.setText(paramString);
  }
  
  public void tG(boolean paramBoolean)
  {
    if (this.oM == null) {
      return;
    }
    TextView localTextView = (TextView)this.oM.findViewById(2131377036);
    if (paramBoolean)
    {
      localTextView.setText(2131720487);
      return;
    }
    localTextView.setText(2131720482);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rdv
 * JD-Core Version:    0.7.0.1
 */