import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.tmassistantbase.network.INetworkChangedObserver;
import mqq.app.AppRuntime;

class viv
  implements INetworkChangedObserver
{
  viv(vit paramvit, viw paramviw, AppRuntime paramAppRuntime, bdvs parambdvs) {}
  
  public void onNetworkChanged()
  {
    if (!bgnt.g(BaseApplicationImpl.getContext()))
    {
      if (viw.a(this.jdField_a_of_type_Viw) != null) {
        viw.a(this.jdField_a_of_type_Viw).a(false);
      }
      if ((this.jdField_a_of_type_MqqAppAppRuntime instanceof QQAppInterface)) {
        ((QQAppInterface)this.jdField_a_of_type_MqqAppAppRuntime).getNetEngine(0).b(this.jdField_a_of_type_Bdvs);
      }
      bgmg.a(this.jdField_a_of_type_Viw.c(), true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     viv
 * JD-Core Version:    0.7.0.1
 */