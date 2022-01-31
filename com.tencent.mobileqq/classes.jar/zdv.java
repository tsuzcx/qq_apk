import com.tencent.mobileqq.apollo.script.SpriteActionScript;
import com.tencent.mobileqq.apollo.script.drawerInfo.SpriteDrawerInfoManager;
import com.tencent.mobileqq.apollo.view.ApolloDrawerInfoViewListener;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

public class zdv
  implements Runnable
{
  public zdv(ApolloDrawerInfoViewListener paramApolloDrawerInfoViewListener, boolean paramBoolean, Object paramObject) {}
  
  public void run()
  {
    try
    {
      if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_JavaLangObject != null))
      {
        if (ApolloDrawerInfoViewListener.a(this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloDrawerInfoViewListener).get() == null) {
          return;
        }
        Object localObject = (ArrayList)this.jdField_a_of_type_JavaLangObject;
        if ((localObject != null) && (((ArrayList)localObject).size() != 0))
        {
          SpriteActionScript localSpriteActionScript = ((SpriteDrawerInfoManager)ApolloDrawerInfoViewListener.a(this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloDrawerInfoViewListener).get()).a();
          if (localSpriteActionScript != null)
          {
            localObject = ((ArrayList)localObject).iterator();
            while (((Iterator)localObject).hasNext()) {
              localSpriteActionScript.a((String)((Iterator)localObject).next(), true);
            }
          }
        }
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("ApolloDrawerInfoViewListener", 1, localThrowable, new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     zdv
 * JD-Core Version:    0.7.0.1
 */