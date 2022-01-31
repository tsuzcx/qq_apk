import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.tencent.common.app.AppInterface;
import java.util.ArrayList;
import java.util.List;

public class wrc
  extends wug
{
  private Context jdField_a_of_type_AndroidContentContext;
  private RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  private bhcw jdField_a_of_type_Bhcw;
  private bhsz jdField_a_of_type_Bhsz;
  private AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  private String jdField_a_of_type_JavaLangString;
  private List<wqk> jdField_a_of_type_JavaUtilList;
  private wsi jdField_a_of_type_Wsi;
  private wsw jdField_a_of_type_Wsw;
  private wsz jdField_a_of_type_Wsz;
  
  public wrc(Activity paramActivity, AppInterface paramAppInterface, View paramView, wus paramwus)
  {
    super(paramActivity, paramView, paramwus);
    this.jdField_a_of_type_AndroidContentContext = paramView.getContext();
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    this.jdField_a_of_type_Bhcw = ((bhcw)paramwus.a(65537, new Object[0]));
  }
  
  private void e()
  {
    this.jdField_a_of_type_Wsi = ((wsi)bhur.a(this.jdField_a_of_type_Bhcw).a(wsi.class));
    this.jdField_a_of_type_Wsi.a().a(this.jdField_a_of_type_Bhcw, new wre(this));
    this.jdField_a_of_type_Wsz = ((wsz)bhur.a(this.jdField_a_of_type_Bhcw).a(wsz.class));
    this.jdField_a_of_type_Wsz.a().a(this.jdField_a_of_type_Bhcw, new wrf(this));
    this.jdField_a_of_type_Wsw = ((wsw)bhur.a(this.jdField_a_of_type_Bhcw).a(wsw.class));
    this.jdField_a_of_type_Wsw.a().a(this.jdField_a_of_type_Bhcw, new wrg(this));
    this.jdField_a_of_type_Wsw.b().a(this.jdField_a_of_type_Bhcw, new wrh(this));
    this.jdField_a_of_type_Wsw.a(this.jdField_a_of_type_Bhcw);
  }
  
  private void f()
  {
    wqa.a(new View[] { this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView }).b(new float[] { 0.0F, 1.0F }).a(300L).a(new wri(this)).b();
  }
  
  protected void a()
  {
    if (this.jdField_a_of_type_AndroidViewView == null) {
      return;
    }
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = ((RecyclerView)this.jdField_a_of_type_AndroidViewView.findViewById(2131296631));
    LinearLayoutManager localLinearLayoutManager = new LinearLayoutManager(this.jdField_a_of_type_AndroidContentContext, 0, false);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setLayoutManager(localLinearLayoutManager);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setItemAnimator(null);
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_Bhsz = new bhsz(this.jdField_a_of_type_AndroidViewView.getContext(), this.jdField_a_of_type_JavaUtilList);
    this.jdField_a_of_type_Bhsz.a(new wrd(this));
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setAdapter(this.jdField_a_of_type_Bhsz);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setVisibility(8);
    e();
  }
  
  public void c()
  {
    super.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     wrc
 * JD-Core Version:    0.7.0.1
 */