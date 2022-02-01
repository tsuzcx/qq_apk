import android.content.Context;
import com.tencent.mobileqq.activity.ForwardOperations;
import com.tencent.mobileqq.activity.contact.SearchResultDialog;
import com.tencent.mobileqq.activity.contact.troop.DiscussionView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.model.FriendManager;
import java.util.ArrayList;
import java.util.List;

public class efn
  extends SearchResultDialog
{
  public efn(DiscussionView paramDiscussionView, Context paramContext, QQAppInterface paramQQAppInterface, int paramInt, ForwardOperations paramForwardOperations)
  {
    super(paramContext, paramQQAppInterface, paramInt, paramForwardOperations);
  }
  
  protected List a(Context paramContext, QQAppInterface paramQQAppInterface, int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    if ((FriendManager)paramQQAppInterface.getManager(8) == null) {
      return localArrayList;
    }
    return c(paramContext, paramQQAppInterface, 0L, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     efn
 * JD-Core Version:    0.7.0.1
 */