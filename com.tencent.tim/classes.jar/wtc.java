import android.widget.ListAdapter;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ListView;

public class wtc
{
  private int bRA = -1;
  private int bRB = -1;
  
  private void a(QQAppInterface paramQQAppInterface, ListView paramListView, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ListViewExposeLogic", 2, "reportListItemMessage : exposeItemIndex -> " + paramInt);
    }
    if (paramInt >= 0)
    {
      Object localObject = paramListView.getAdapter();
      if ((localObject != null) && (paramInt < ((ListAdapter)localObject).getCount()))
      {
        localObject = ((ListAdapter)localObject).getItem(paramInt);
        if ((localObject instanceof MessageRecord))
        {
          localObject = (MessageRecord)localObject;
          wta.a(paramListView.getContext(), paramQQAppInterface, (MessageRecord)localObject, 1);
        }
      }
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, ListView paramListView)
  {
    int j = paramListView.mFirstPosition;
    int k = paramListView.getChildCount();
    if (QLog.isColorLevel()) {
      QLog.d("ListViewExposeLogic", 2, "reportExposeOnShowFirst : curFirstPosition -> " + j + ", childCount -> " + k);
    }
    int i = j;
    while (i < j + k)
    {
      a(paramQQAppInterface, paramListView, i);
      i += 1;
    }
    this.bRA = paramListView.mFirstPosition;
    this.bRB = paramListView.getChildCount();
  }
  
  public void b(QQAppInterface paramQQAppInterface, ListView paramListView)
  {
    int j = paramListView.mFirstPosition;
    int k = paramListView.getChildCount();
    if ((j == this.bRA) && (this.bRB == k)) {
      return;
    }
    int i = -1;
    if (j < this.bRA) {
      i = j;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ListViewExposeLogic", 2, "handleListViewScroll : curExposeItemIndex -> " + i + ", curFirstPosition -> " + j + ", childCount -> " + k);
      }
      this.bRA = j;
      this.bRB = k;
      a(paramQQAppInterface, paramListView, i);
      return;
      if (j + k > this.bRA + this.bRB) {
        i = j + k - 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wtc
 * JD-Core Version:    0.7.0.1
 */