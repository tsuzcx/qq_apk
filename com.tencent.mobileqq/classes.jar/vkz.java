import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.tmassistantbase.network.INetworkChangedObserver;
import mqq.app.AppRuntime;

class vkz
  implements INetworkChangedObserver
{
  vkz(vkx paramvkx, vla paramvla, AppRuntime paramAppRuntime, beum parambeum) {}
  
  public void onNetworkChanged()
  {
    if (!bhnv.g(BaseApplicationImpl.getContext()))
    {
      if (vla.a(this.jdField_a_of_type_Vla) != null) {
        vla.a(this.jdField_a_of_type_Vla).a(false);
      }
      if ((this.jdField_a_of_type_MqqAppAppRuntime instanceof QQAppInterface)) {
        ((QQAppInterface)this.jdField_a_of_type_MqqAppAppRuntime).getNetEngine(0).b(this.jdField_a_of_type_Beum);
      }
      bhmi.a(this.jdField_a_of_type_Vla.c(), true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vkz
 * JD-Core Version:    0.7.0.1
 */