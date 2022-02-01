import java.util.ArrayList;

public class avnh
{
  public ArrayList<String> EP = new ArrayList();
  public String cMk;
  public int exA;
  public int tabID;
  public String tabIcon;
  public String tabName;
  
  public avnh() {}
  
  public avnh(int paramInt1, String paramString1, String paramString2, String paramString3, ArrayList<String> paramArrayList, int paramInt2)
  {
    this.tabID = paramInt1;
    this.tabName = paramString1;
    this.tabIcon = paramString2;
    this.cMk = paramString3;
    this.EP = paramArrayList;
    this.exA = paramInt2;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = true;
    boolean bool3 = false;
    boolean bool1;
    if (this == paramObject) {
      bool1 = true;
    }
    label116:
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
                  return bool1;
                  bool1 = bool3;
                } while (paramObject == null);
                bool1 = bool3;
              } while (getClass() != paramObject.getClass());
              paramObject = (avnh)paramObject;
              bool1 = bool3;
            } while (this.tabID != paramObject.tabID);
            bool1 = bool3;
          } while (this.exA != paramObject.exA);
          if (this.tabName == null) {
            break;
          }
          bool1 = bool3;
        } while (!this.tabName.equals(paramObject.tabName));
        if (this.tabIcon == null) {
          break label170;
        }
        bool1 = bool3;
      } while (!this.tabIcon.equals(paramObject.tabIcon));
      if (this.cMk == null) {
        break label179;
      }
      bool1 = bool3;
    } while (!this.cMk.equals(paramObject.cMk));
    label140:
    if (this.EP != null) {
      bool1 = this.EP.equals(paramObject.EP);
    }
    for (;;)
    {
      return bool1;
      if (paramObject.tabName == null) {
        break;
      }
      return false;
      label170:
      if (paramObject.tabIcon == null) {
        break label116;
      }
      return false;
      label179:
      if (paramObject.cMk == null) {
        break label140;
      }
      return false;
      bool1 = bool2;
      if (paramObject.EP != null) {
        bool1 = false;
      }
    }
  }
  
  public int hashCode()
  {
    int m = 0;
    int n = this.tabID;
    int i;
    int j;
    if (this.tabName != null)
    {
      i = this.tabName.hashCode();
      if (this.tabIcon == null) {
        break label107;
      }
      j = this.tabIcon.hashCode();
      label39:
      if (this.cMk == null) {
        break label112;
      }
    }
    label107:
    label112:
    for (int k = this.cMk.hashCode();; k = 0)
    {
      if (this.EP != null) {
        m = this.EP.hashCode();
      }
      return ((k + (j + (i + n * 31) * 31) * 31) * 31 + m) * 31 + this.exA;
      i = 0;
      break;
      j = 0;
      break label39;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     avnh
 * JD-Core Version:    0.7.0.1
 */