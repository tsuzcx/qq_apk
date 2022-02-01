import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mobileqq.activity.contacts.base.Contacts.a;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.troop.data.TroopBarPOI;
import com.tencent.mobileqq.widget.PullRefreshHeader;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.c;
import com.tencent.widget.XListView;
import dov.com.qq.im.capture.poi.FacePoiUI.2;
import dov.com.qq.im.capture.poi.FacePoiUI.4;
import java.util.ArrayList;
import mqq.os.MqqHandler;

public class axtm
  implements View.OnClickListener, axtf.a, AdapterView.c
{
  ViewStub A;
  long BN = 0L;
  aypy a = null;
  private axtf jdField_b_of_type_Axtf = new axtf(this);
  private axtm.a jdField_b_of_type_Axtm$a;
  PullRefreshHeader d;
  LinearLayout eY;
  LinearLayout eZ;
  public XListView i = null;
  View mRootView;
  View oJ;
  View oK = null;
  View oL = null;
  View oM = null;
  TextView yq = null;
  
  private void da(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1)
    {
      this.eZ.setVisibility(4);
      this.eY.setVisibility(4);
      this.i.setVisibility(0);
      return;
    }
    this.i.setVisibility(4);
    if (paramBoolean2)
    {
      this.eZ.setVisibility(4);
      this.eY.setVisibility(0);
      return;
    }
    this.eY.setVisibility(4);
    this.eZ.setVisibility(0);
  }
  
  private void xd(int paramInt)
  {
    if (this.d != null)
    {
      Contacts.a locala = (Contacts.a)this.d.getTag();
      if (locala != null)
      {
        locala.bpP = false;
        new Handler(Looper.getMainLooper()).postDelayed(new FacePoiUI.4(this), 800L);
        if (paramInt == 0) {
          this.BN = System.currentTimeMillis();
        }
        this.d.tT(paramInt);
      }
    }
  }
  
  public axtf a()
  {
    return this.jdField_b_of_type_Axtf;
  }
  
  public void a(axtm.a parama)
  {
    this.jdField_b_of_type_Axtm$a = parama;
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, ArrayList<TroopBarPOI> paramArrayList, TroopBarPOI paramTroopBarPOI)
  {
    if (paramBoolean1)
    {
      tG(paramBoolean2);
      if (this.a != null)
      {
        this.a.a(paramArrayList, paramTroopBarPOI);
        this.a.notifyDataSetChanged();
        if (paramArrayList.isEmpty()) {
          au(false, false);
        }
      }
      else
      {
        if (paramTroopBarPOI == null) {
          break label100;
        }
        if (!TextUtils.isEmpty(paramTroopBarPOI.name)) {
          break label91;
        }
      }
      label91:
      for (paramArrayList = paramTroopBarPOI.Tr;; paramArrayList = paramTroopBarPOI.name)
      {
        d(1, new String[] { paramArrayList });
        return;
        au(true, false);
        break;
      }
      label100:
      d(0, new String[0]);
      return;
    }
    d(3, new String[0]);
  }
  
  public boolean aPI()
  {
    return (this.oJ != null) && (this.oJ.getVisibility() == 0);
  }
  
  public void au(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (Looper.getMainLooper() == Looper.myLooper())
    {
      da(paramBoolean1, paramBoolean2);
      return;
    }
    ThreadManager.getUIHandler().post(new FacePoiUI.2(this, paramBoolean1, paramBoolean2));
  }
  
  public void bm(View paramView)
  {
    if (paramView == null) {
      throw new IllegalStateException("FacePoiUI rootView can't be null");
    }
    this.mRootView = paramView;
    this.A = ((ViewStub)this.mRootView.findViewById(2131375231));
  }
  
  public void bsQ()
  {
    if (this.oJ == null)
    {
      this.oJ = this.A.inflate();
      this.yq = ((TextView)this.oJ.findViewById(2131369579));
      this.oK = this.oJ.findViewById(2131377804);
      this.oL = this.oJ.findViewById(2131377834);
      this.eY = ((LinearLayout)this.oJ.findViewById(2131366440));
      this.eZ = ((LinearLayout)this.oJ.findViewById(2131366441));
      this.yq.setOnClickListener(this);
      this.eZ.setOnClickListener(this);
      this.oK.setOnClickListener(this);
      this.oL.setOnClickListener(this);
      ((TextView)this.oJ.findViewById(2131369627)).setText(acfp.m(2131706035));
      this.i = ((XListView)this.oJ.findViewById(2131373455));
      btl();
      btn();
      this.i.setOnScrollListener(new axtn(this));
      this.a = new aypy(this.mRootView.getContext());
      this.a.a(this.jdField_b_of_type_Axtf.eL(), this.jdField_b_of_type_Axtf.a());
      this.i.setAdapter(this.a);
      this.i.setOnItemClickListener(this);
    }
    this.oJ.setVisibility(0);
  }
  
  protected void btl()
  {
    if (this.d == null) {
      this.d = ((PullRefreshHeader)LayoutInflater.from(this.mRootView.getContext()).inflate(2131559847, null, false));
    }
    Contacts.a locala = new Contacts.a();
    this.d.setTag(locala);
    this.i.setOverscrollHeader(null);
    this.i.setOverScrollHeader(this.d);
    if (QLog.isColorLevel()) {
      QLog.d("zivonchen", 2, "setOverScrollHeader----------------------");
    }
    this.i.setOverScrollListener(new axto(this));
  }
  
  protected void btn()
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
    if (this.i.getFooterViewsCount() > 0) {
      this.i.removeFooterView(this.oM);
    }
    this.i.addFooterView(this.oM);
  }
  
  public void d(int paramInt, String... paramVarArgs)
  {
    switch (paramInt)
    {
    case 0: 
    case 2: 
    default: 
    case 3: 
      do
      {
        return;
        if ((paramVarArgs != null) && (paramVarArgs.length > 0)) {
          QQToast.a(this.mRootView.getContext(), paramVarArgs[0], 1).show();
        }
      } while ((this.oJ == null) || (this.oJ.getVisibility() != 0));
      au(false, false);
      return;
    }
    if ((paramVarArgs != null) && (paramVarArgs.length > 0) && (!TextUtils.isEmpty(paramVarArgs[0])))
    {
      if (TextUtils.isEmpty(paramVarArgs[0]))
      {
        d(3, new String[0]);
        return;
      }
      paramVarArgs = paramVarArgs[0];
      return;
    }
    d(0, new String[0]);
  }
  
  public void notifyDataChange()
  {
    if (this.a != null)
    {
      this.a.a(this.jdField_b_of_type_Axtf.eL(), this.jdField_b_of_type_Axtf.a());
      this.a.notifyDataSetChanged();
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
      this.jdField_b_of_type_Axtf.onCancel();
      if (this.jdField_b_of_type_Axtm$a != null)
      {
        this.jdField_b_of_type_Axtm$a.eNC();
      }
      else
      {
        onHide();
        continue;
        if (this.jdField_b_of_type_Axtm$a != null)
        {
          this.jdField_b_of_type_Axtm$a.eND();
          continue;
          this.jdField_b_of_type_Axtf.btk();
          au(false, true);
        }
      }
    }
  }
  
  public void onHide()
  {
    if ((this.oJ != null) && (this.oJ.getVisibility() == 0)) {
      this.oJ.setVisibility(8);
    }
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if ((this.jdField_b_of_type_Axtf.os(paramInt)) || (this.a == null)) {
      return;
    }
    paramView = (TroopBarPOI)this.jdField_b_of_type_Axtf.eL().get(paramInt);
    this.jdField_b_of_type_Axtf.b(paramView);
    notifyDataChange();
    ayho localayho = this.jdField_b_of_type_Axtf.a();
    if (paramView != null) {
      if (TextUtils.isEmpty(paramView.name))
      {
        paramAdapterView = paramView.Tr;
        d(1, new String[] { paramAdapterView });
        if (localayho != null) {
          localayho.a(paramView);
        }
      }
    }
    for (;;)
    {
      if (this.jdField_b_of_type_Axtm$a == null) {
        break label150;
      }
      this.jdField_b_of_type_Axtm$a.aNX();
      return;
      paramAdapterView = paramView.name;
      break;
      d(0, new String[0]);
      if (localayho != null) {
        localayho.a(null);
      }
    }
    label150:
    onHide();
  }
  
  protected void tG(boolean paramBoolean)
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
    
    public abstract void eNC();
    
    public abstract void eND();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     axtm
 * JD-Core Version:    0.7.0.1
 */