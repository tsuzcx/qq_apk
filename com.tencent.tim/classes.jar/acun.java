import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class acun
{
  public static acul a(acuo paramacuo, ArrayList<acum> paramArrayList)
  {
    if ((paramacuo != null) && (paramArrayList != null)) {}
    for (;;)
    {
      int i;
      try
      {
        if (paramacuo.getUrl() != null) {
          break label134;
        }
        QLog.e("JumpParserFactory", 1, "createJumpParser error: param is null");
        return null;
      }
      catch (Exception paramacuo)
      {
        acum localacum;
        QLog.e("JumpParserFactory", 1, "createJumpParser error: " + paramacuo.getMessage());
        return null;
      }
      if (i < paramArrayList.size())
      {
        localacum = (acum)paramArrayList.get(i);
        if (!paramacuo.getUrl().startsWith(localacum.rV())) {
          break label141;
        }
        paramacuo = localacum.e();
        if (paramacuo != null)
        {
          paramacuo = paramacuo.newInstance();
          if ((paramacuo instanceof acul)) {
            paramacuo = (acul)paramacuo;
          } else {
            QLog.e("JumpParserFactory", 1, "createJumpParser error: not extends JumpParserBase");
          }
        }
        else
        {
          paramacuo = null;
        }
      }
      else
      {
        paramacuo = null;
        continue;
        label134:
        i = 0;
        continue;
      }
      return paramacuo;
      label141:
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     acun
 * JD-Core Version:    0.7.0.1
 */