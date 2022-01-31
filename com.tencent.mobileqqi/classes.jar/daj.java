import android.annotation.SuppressLint;
import android.content.Context;
import com.tencent.mobileqq.activity.PublicAccountActivity;
import com.tencent.mobileqq.activity.contact.SearchResultDialog;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.List;

public class daj
  extends SearchResultDialog
{
  public daj(PublicAccountActivity paramPublicAccountActivity, Context paramContext, QQAppInterface paramQQAppInterface, int paramInt)
  {
    super(paramContext, paramQQAppInterface, paramInt);
  }
  
  @SuppressLint({"UseSparseArrays"})
  protected List a(Context paramContext, QQAppInterface paramQQAppInterface, int paramInt)
  {
    return a(paramContext, paramQQAppInterface, 0L, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     daj
 * JD-Core Version:    0.7.0.1
 */