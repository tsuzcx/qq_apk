import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import java.util.ArrayList;
import java.util.List;

public class axco
  extends axgh
{
  private RecyclerView K;
  private List<axby> Mt;
  private axcz jdField_a_of_type_Axcz;
  private axdy jdField_a_of_type_Axdy;
  private axgg jdField_a_of_type_Axgg;
  private axgf b;
  private awtq c;
  private String cTL;
  private Context mContext;
  
  public axco(Activity paramActivity, View paramView, axgi paramaxgi)
  {
    super(paramActivity, paramView, paramaxgi);
    this.mContext = paramView.getContext();
    this.c = ((awtq)paramaxgi.a(65537, new Object[0]));
  }
  
  private void b(axby paramaxby)
  {
    this.jdField_a_of_type_Axcz.f(paramaxby);
    if (paramaxby == null)
    {
      this.jdField_a_of_type_Axcz.e(null);
      this.cTL = null;
      return;
    }
    this.cTL = paramaxby.id;
    switch (paramaxby.state)
    {
    case 1: 
    default: 
      return;
    case 0: 
      this.jdField_a_of_type_Axcz.d(paramaxby);
      return;
    }
    this.jdField_a_of_type_Axcz.e(paramaxby);
  }
  
  private void biN()
  {
    this.b = ((axgf)awuh.a(this.c).b(axgf.class));
    this.b.t.a(this.c, new axcq(this));
    this.jdField_a_of_type_Axgg = ((axgg)awuh.a(this.c).b(axgg.class));
    this.jdField_a_of_type_Axgg.p().a(this.c, new axcr(this));
    this.jdField_a_of_type_Axcz = ((axcz)awuh.a(this.c).b(axcz.class));
    this.jdField_a_of_type_Axcz.g().a(this.c, new axcs(this));
    this.jdField_a_of_type_Axcz.h().a(this.c, new axct(this));
    this.jdField_a_of_type_Axcz.k(this.c);
  }
  
  private void eIR()
  {
    spf.b(new View[] { this.K }).b(new float[] { 0.0F, 1.0F }).a(300L).a(new axcu(this)).b();
  }
  
  protected void initView()
  {
    if (this.mRootView == null) {
      return;
    }
    this.K = ((RecyclerView)this.mRootView.findViewById(2131362312));
    LinearLayoutManager localLinearLayoutManager = new LinearLayoutManager(this.mContext, 0, false);
    this.K.setLayoutManager(localLinearLayoutManager);
    this.K.setItemAnimator(null);
    this.Mt = new ArrayList();
    this.jdField_a_of_type_Axdy = new axdy(this.mRootView.getContext(), this.Mt);
    this.jdField_a_of_type_Axdy.a(new axcp(this));
    this.K.setAdapter(this.jdField_a_of_type_Axdy);
    this.K.setVisibility(8);
    biN();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     axco
 * JD-Core Version:    0.7.0.1
 */