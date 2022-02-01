import android.content.res.Resources;
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
import com.tencent.mobileqq.troop.data.TroopBarPOI;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.c;
import com.tencent.widget.XListView;
import dov.com.qq.im.capture.poi.FacePoiSearchUI.2;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoParams;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class axti
  implements View.OnClickListener, AdapterView.c
{
  View FS;
  aypy jdField_a_of_type_Aypy = null;
  EditVideoParams jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams;
  public EditText af;
  private axti.a jdField_b_of_type_Axti$a;
  pub.d jdField_b_of_type_Pub$d = pub.d.a();
  WeakReference<ayho> dc;
  private TextWatcher jdField_i_of_type_AndroidTextTextWatcher = new axtl(this);
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
  
  private void btk()
  {
    ram.d("FacePoiSearchUI", "requestPoiList");
    String str = this.af.getText().toString();
    this.jdField_b_of_type_Pub$d.rq(str);
    if (TextUtils.isEmpty(str))
    {
      ram.i("FacePoiSearchUI", "requestPoiList text is null ignore");
      this.nw.clear();
      this.jdField_a_of_type_Aypy.notifyDataSetChanged();
      btr();
      return;
    }
    pub localpub = (pub)psx.a(9);
    pua localpua = pub.a();
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams != null) {
      localpua = rpb.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams);
    }
    if (localpua != null) {
      localpub.a(localpua, this.jdField_b_of_type_Pub$d, new axtk(this, str));
    }
    if (this.jdField_b_of_type_Pub$d.IZ())
    {
      btq();
      this.oM.setVisibility(4);
      return;
    }
    this.oM.setVisibility(0);
  }
  
  public boolean Lk()
  {
    if ((this.FS != null) && (this.FS.getVisibility() == 0))
    {
      aurd.hide(this.mRootView);
      return true;
    }
    return false;
  }
  
  public ayho a()
  {
    if (this.dc == null) {
      throw new IllegalStateException("EditVideoPoiPickerCallback is null");
    }
    return (ayho)this.dc.get();
  }
  
  public void a(axti.a parama)
  {
    this.jdField_b_of_type_Axti$a = parama;
  }
  
  public void a(ayho paramayho)
  {
    this.dc = new WeakReference(paramayho);
  }
  
  public boolean aPI()
  {
    return (this.FS != null) && (this.FS.getVisibility() == 0);
  }
  
  public void bm(View paramView)
  {
    if (paramView == null) {
      throw new IllegalStateException("FacePoiSearchUI rootView can't be null");
    }
    this.mRootView = paramView;
    this.n = ((ViewStub)this.mRootView.findViewById(2131375230));
  }
  
  public void bsQ()
  {
    if (this.FS == null)
    {
      this.FS = this.n.inflate();
      this.oN = this.FS.findViewById(2131373456);
      this.af = ((EditText)this.FS.findViewById(2131369305));
      this.oO = this.FS.findViewById(2131364236);
      this.jdField_i_of_type_ComTencentWidgetXListView = ((XListView)this.FS.findViewById(2131373455));
      this.oP = this.FS.findViewById(2131373464);
      this.oQ = this.FS.findViewById(2131377869);
      this.oR = this.FS.findViewById(2131377819);
      this.yr = ((TextView)this.FS.findViewById(2131377820));
      this.oN.setOnClickListener(this);
      this.oP.setOnClickListener(this);
      this.jdField_i_of_type_ComTencentWidgetXListView.setOnItemClickListener(this);
      this.jdField_a_of_type_Aypy = new aypy(this.mRootView.getContext());
      this.nw = new ArrayList();
      this.jdField_a_of_type_Aypy.a(this.nw, null);
      this.jdField_i_of_type_ComTencentWidgetXListView.setEmptyView(this.oP);
      this.jdField_i_of_type_ComTencentWidgetXListView.setOnScrollListener(new axtj(this));
      btp();
      this.jdField_i_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_Aypy);
      this.af.addTextChangedListener(this.jdField_i_of_type_AndroidTextTextWatcher);
      this.oO.setOnClickListener(this);
    }
    this.FS.setVisibility(0);
    this.af.setText("");
    this.af.post(new FacePoiSearchUI.2(this));
    this.oM.setVisibility(4);
  }
  
  protected void btp()
  {
    if (this.oM == null)
    {
      this.oM = LayoutInflater.from(this.mRootView.getContext()).inflate(2131559847, null);
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
  
  public void dismiss()
  {
    if ((this.FS != null) && (this.FS.getVisibility() == 0)) {
      this.FS.setVisibility(4);
    }
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
      aurd.hide(this.mRootView);
      continue;
      Lk();
      dismiss();
      if (this.jdField_b_of_type_Axti$a != null) {
        this.jdField_b_of_type_Axti$a.aNX();
      }
    }
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
      paramView = (ayho)this.dc.get();
      if (paramView != null) {
        paramView.a(paramAdapterView);
      }
      if ((this.FS != null) && (this.FS.getVisibility() == 0) && (this.jdField_b_of_type_Axti$a != null)) {
        this.jdField_b_of_type_Axti$a.aNX();
      }
      aurd.hide(this.mRootView);
    }
  }
  
  public void setEditVideoParams(EditVideoParams paramEditVideoParams)
  {
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams = paramEditVideoParams;
  }
  
  void su(String paramString)
  {
    this.jdField_i_of_type_ComTencentWidgetXListView.setVisibility(0);
    this.oP.setVisibility(0);
    this.oQ.setVisibility(4);
    this.oR.setVisibility(0);
    paramString = this.mRootView.getResources().getString(2131701927, new Object[] { paramString });
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
  
  public static abstract interface a
  {
    public abstract void aNX();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     axti
 * JD-Core Version:    0.7.0.1
 */