import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.ArrayList;
import java.util.Iterator;

public class ajnl
{
  public static int a(QQAppInterface paramQQAppInterface, String paramString, long paramLong1, long paramLong2)
  {
    return a(paramQQAppInterface, paramString, paramLong1, paramLong2, false);
  }
  
  public static int a(QQAppInterface paramQQAppInterface, String paramString, long paramLong1, long paramLong2, boolean paramBoolean)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      int i = ajoc.b(paramQQAppInterface, paramString, paramLong1, paramLong2);
      if (i != 0) {
        return i;
      }
    }
    switch ((int)paramLong1)
    {
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
                              return 0;
                              if (paramLong2 == 0L) {
                                return 2130851182;
                              }
                              if (paramLong2 == 1L) {
                                return 2130851183;
                              }
                            } while (paramLong2 != 2L);
                            return 2130851184;
                            if (paramLong2 == 0L) {
                              return 2130851176;
                            }
                            if (paramLong2 == 1L) {
                              return 2130851177;
                            }
                          } while (paramLong2 != 2L);
                          return 2130851178;
                          if (paramLong2 == 0L) {
                            return 2130851179;
                          }
                          if (paramLong2 == 1L) {
                            return 2130851180;
                          }
                        } while (paramLong2 != 2L);
                        return 2130851181;
                        if (paramLong2 == 1L) {
                          return 2130851173;
                        }
                        if (paramLong2 == 2L) {
                          return 2130851174;
                        }
                      } while (paramLong2 != 3L);
                      return 2130851175;
                      if (paramLong2 == 1L) {
                        return 2130851200;
                      }
                    } while (paramLong2 != 2L);
                    return 2130851158;
                    if (paramLong2 == 1L) {
                      return 2130851204;
                    }
                  } while (paramLong2 != 2L);
                  return 2130851162;
                  if (paramLong2 == 1L) {
                    return 2130851192;
                  }
                } while (paramLong2 != 2L);
                return 2130851191;
                if (paramLong2 == 1L) {
                  return 2130851198;
                }
              } while (paramLong2 != 2L);
              return 2130851199;
              if (paramLong2 == 1L) {
                return 2130851203;
              }
            } while (paramLong2 != 2L);
            return 2130851161;
          } while (paramLong2 != 1L);
          return 2130851197;
        } while ((!paramBoolean) || (paramLong2 != 1L));
        return 2130851195;
        if (paramLong2 == 1L) {
          return 2130851188;
        }
        if (paramLong2 == 2L) {
          return 2130851189;
        }
      } while (paramLong2 != 3L);
      return 2130851190;
      if (paramLong2 == 1L) {
        return 2130851170;
      }
      if (paramLong2 == 2L) {
        return 2130851171;
      }
    } while (paramLong2 != 3L);
    return 2130851172;
  }
  
  public static ajog a(QQAppInterface paramQQAppInterface, long paramLong)
  {
    return aelb.b().a(paramLong);
  }
  
  public static String a(QQAppInterface paramQQAppInterface, String paramString, long paramLong1, long paramLong2)
  {
    int i = a(paramQQAppInterface, paramString, paramLong1, paramLong2);
    if (i != 0) {
      return ajnu.eB(i);
    }
    return "";
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, long paramLong1, long paramLong2)
  {
    return false;
  }
  
  public static String b(QQAppInterface paramQQAppInterface, long paramLong1, long paramLong2)
  {
    return l(paramQQAppInterface, ajnu.i(paramLong1, paramLong2));
  }
  
  public static boolean b(QQAppInterface paramQQAppInterface, long paramLong1, long paramLong2)
  {
    if (!j(paramQQAppInterface, paramLong1)) {}
    while (((paramLong1 == 1L) || (paramLong1 == 2L) || (paramLong1 == 3L)) && (paramLong2 > 0L) && (!ajok.arl())) {
      return false;
    }
    return true;
  }
  
  public static int c(QQAppInterface paramQQAppInterface, String paramString1, String paramString2)
  {
    return a(paramQQAppInterface, paramString1, ajnu.ap(paramString2), ajnu.ao(paramString2));
  }
  
  public static String f(QQAppInterface paramQQAppInterface, String paramString1, String paramString2)
  {
    return a(paramQQAppInterface, paramString1, ajnu.ap(paramString2), ajnu.ao(paramString2));
  }
  
  public static ArrayList<ajog.a> g(QQAppInterface paramQQAppInterface)
  {
    Object localObject = aelb.b().cR();
    ArrayList localArrayList = new ArrayList();
    localObject = ((ArrayList)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      ajog.a locala = (ajog.a)((Iterator)localObject).next();
      if (b(paramQQAppInterface, locala.type, locala.ada)) {
        localArrayList.add(locala);
      }
    }
    return localArrayList;
  }
  
  public static boolean i(QQAppInterface paramQQAppInterface, long paramLong)
  {
    return false;
  }
  
  public static boolean j(QQAppInterface paramQQAppInterface, long paramLong)
  {
    return ((paramLong != 1L) && (paramLong != 2L) && (paramLong != 3L)) || (ajok.nx(paramQQAppInterface.getCurrentUin()));
  }
  
  public static String l(QQAppInterface paramQQAppInterface, String paramString)
  {
    paramQQAppInterface = aelb.b().a(paramString);
    if (paramQQAppInterface != null) {
      return paramQQAppInterface.name;
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajnl
 * JD-Core Version:    0.7.0.1
 */