import java.util.Comparator;

public class pui
  implements Comparator<puh>
{
  public int a(puh parampuh1, puh parampuh2)
  {
    int k = 0;
    int m = 0;
    int n = 0;
    int i1 = 0;
    int i = 0;
    int j = 1;
    if (parampuh1.nodeType == 1) {
      if (parampuh2.nodeType != 1) {}
    }
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  for (;;)
                  {
                    return i;
                    i = -1;
                  }
                  i = j;
                } while (parampuh2.nodeType == 1);
                if (((parampuh2.nodeType == 13) && (parampuh2.unreadCount == 0)) || ((parampuh1.nodeType == 13) && (parampuh1.unreadCount > 0))) {
                  return -1;
                }
                if (parampuh2.nodeType != 13) {
                  break;
                }
                i = j;
              } while (parampuh2.unreadCount > 0);
              if (parampuh1.nodeType != 13) {
                break;
              }
              i = j;
            } while (parampuh1.unreadCount == 0);
            if (parampuh1.nodeType == 2)
            {
              if (parampuh2.nodeType == 2) {}
              for (i = k;; i = -1) {
                return i;
              }
            }
            i = j;
          } while (parampuh2.nodeType == 2);
          if (parampuh1.nodeType == 3)
          {
            if (parampuh2.nodeType == 3) {}
            for (i = m;; i = -1) {
              return i;
            }
          }
          i = j;
        } while (parampuh2.nodeType == 3);
        if ((parampuh1.nodeType == 5) && (parampuh1.sz() > 0))
        {
          if ((parampuh2.nodeType == 5) && (parampuh2.sz() > 0)) {}
          for (i = n;; i = -1) {
            return i;
          }
        }
        if (parampuh2.nodeType != 5) {
          break;
        }
        i = j;
      } while (parampuh2.sz() > 0);
      if (parampuh1.nodeType == 4)
      {
        if (parampuh2.nodeType == 4) {}
        for (i = i1;; i = 1) {
          return i;
        }
      }
      if (parampuh2.nodeType == 4) {
        return -1;
      }
      if ((parampuh1.unreadCount > 0) && (parampuh2.unreadCount == 0)) {
        return -1;
      }
      if (parampuh1.unreadCount != 0) {
        break;
      }
      i = j;
    } while (parampuh2.unreadCount > 0);
    return -pvs.compareLong(parampuh1.nodeInfoTimeStamp, parampuh2.nodeInfoTimeStamp);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pui
 * JD-Core Version:    0.7.0.1
 */