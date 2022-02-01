import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.tencent.biz.richframework.part.block.BlockContainer;
import java.util.ArrayList;

public class zoj
  extends zok
{
  private final int a;
  protected BlockContainer a;
  protected final ArrayList<zou> a;
  private int b;
  private int c;
  
  public BlockContainer a()
  {
    return this.jdField_a_of_type_ComTencentBizRichframeworkPartBlockBlockContainer;
  }
  
  protected BlockContainer a(Context paramContext)
  {
    return new BlockContainer(paramContext);
  }
  
  public String a()
  {
    return "BlockPart";
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((a() != null) && (a().a() != null)) {
      a().a().a(paramInt1, paramInt2, paramIntent);
    }
  }
  
  protected void a(View paramView)
  {
    super.a(paramView);
    if (this.jdField_a_of_type_Int != 0) {
      this.jdField_a_of_type_ComTencentBizRichframeworkPartBlockBlockContainer = ((BlockContainer)paramView.findViewById(this.jdField_a_of_type_Int));
    }
    if (this.jdField_a_of_type_ComTencentBizRichframeworkPartBlockBlockContainer == null) {
      this.jdField_a_of_type_ComTencentBizRichframeworkPartBlockBlockContainer = a(paramView.getContext());
    }
    this.jdField_a_of_type_ComTencentBizRichframeworkPartBlockBlockContainer.setLayoutManagerType(this.c, this.b);
    this.jdField_a_of_type_ComTencentBizRichframeworkPartBlockBlockContainer.setBlockWrapper(this);
    this.jdField_a_of_type_ComTencentBizRichframeworkPartBlockBlockContainer.setParentFragment(a());
    this.jdField_a_of_type_ComTencentBizRichframeworkPartBlockBlockContainer.a(this.jdField_a_of_type_JavaUtilArrayList);
    this.jdField_a_of_type_ComTencentBizRichframeworkPartBlockBlockContainer.c();
  }
  
  public boolean a()
  {
    if ((this.jdField_a_of_type_ComTencentBizRichframeworkPartBlockBlockContainer != null) && (this.jdField_a_of_type_ComTencentBizRichframeworkPartBlockBlockContainer.a())) {
      return true;
    }
    return super.a();
  }
  
  public void onActivityCreated(Activity paramActivity, Bundle paramBundle) {}
  
  public void onActivityDestroyed(Activity paramActivity)
  {
    if ((a() != null) && (a().a() != null)) {
      a().a().onActivityDestroyed(paramActivity);
    }
    if (a() != null) {
      a().b();
    }
  }
  
  public void onActivityPaused(Activity paramActivity)
  {
    if ((a() != null) && (a().a() != null)) {
      a().a().onActivityPaused(paramActivity);
    }
  }
  
  public void onActivityResumed(Activity paramActivity)
  {
    if ((a() != null) && (a().a() != null)) {
      a().a().onActivityResumed(paramActivity);
    }
  }
  
  public void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {}
  
  public void onActivityStarted(Activity paramActivity)
  {
    if ((a() != null) && (a().a() != null)) {
      a().a().onActivityStarted(paramActivity);
    }
  }
  
  public void onActivityStopped(Activity paramActivity)
  {
    if ((a() != null) && (a().a() != null)) {
      a().a().onActivityStopped(paramActivity);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zoj
 * JD-Core Version:    0.7.0.1
 */