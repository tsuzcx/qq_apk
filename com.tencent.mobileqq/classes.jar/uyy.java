import android.widget.ImageView;
import com.tencent.mobileqq.activity.MultiForwardActivity;
import com.tencent.mobileqq.activity.aio.item.ApolloItemBuilder;
import com.tencent.mobileqq.activity.aio.item.ApolloItemBuilder.Holder;
import com.tencent.mobileqq.data.MessageForApollo;
import java.lang.ref.WeakReference;

public class uyy
  implements Runnable
{
  int jdField_a_of_type_Int;
  WeakReference jdField_a_of_type_JavaLangRefWeakReference;
  WeakReference b;
  WeakReference c;
  
  public uyy(ApolloItemBuilder paramApolloItemBuilder, ApolloItemBuilder.Holder paramHolder, MessageForApollo paramMessageForApollo, int paramInt)
  {
    this.b = new WeakReference(paramApolloItemBuilder);
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramHolder);
    this.c = new WeakReference(paramMessageForApollo);
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void run()
  {
    ApolloItemBuilder localApolloItemBuilder = (ApolloItemBuilder)this.b.get();
    ApolloItemBuilder.Holder localHolder = (ApolloItemBuilder.Holder)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    MessageForApollo localMessageForApollo = (MessageForApollo)this.c.get();
    if ((localApolloItemBuilder == null) || (localHolder == null) || (localMessageForApollo == null)) {
      break label45;
    }
    label45:
    while (!(localHolder instanceof ApolloItemBuilder.Holder)) {
      return;
    }
    if (this.jdField_a_of_type_Int == 0) {
      if (!(localHolder.c.getContext() instanceof MultiForwardActivity))
      {
        if (!localMessageForApollo.isSend()) {
          break label148;
        }
        localHolder.c.setVisibility(0);
        localHolder.d.setVisibility(8);
      }
    }
    for (;;)
    {
      ApolloItemBuilder.a(localApolloItemBuilder, true);
      if ((this.jdField_a_of_type_Int != 1) || (ApolloItemBuilder.a(localApolloItemBuilder) != localMessageForApollo.uniseq)) {
        break;
      }
      localHolder.c.setVisibility(8);
      localHolder.d.setVisibility(8);
      ApolloItemBuilder.a(localApolloItemBuilder, 0L);
      return;
      label148:
      localHolder.c.setVisibility(8);
      localHolder.d.setVisibility(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     uyy
 * JD-Core Version:    0.7.0.1
 */