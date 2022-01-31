package com.tencent.mobileqq.troopinfo;

import android.content.Context;
import com.tencent.util.ZipUtil;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class GroupCatalogTool
{
  private static GroupCatalogTool jdField_a_of_type_ComTencentMobileqqTroopinfoGroupCatalogTool;
  private static Object jdField_a_of_type_JavaLangObject = new Object();
  public static final String a = "group_catalog.xml";
  public static final String b = "group_catalog";
  private GroupCatalogBean jdField_a_of_type_ComTencentMobileqqTroopinfoGroupCatalogBean;
  private File jdField_a_of_type_JavaIoFile = new File(a(paramContext) + "group_catalog.xml");
  private ArrayList jdField_a_of_type_JavaUtilArrayList;
  
  private GroupCatalogTool(Context paramContext) {}
  
  private GroupCatalogBean a(GroupCatalogBean paramGroupCatalogBean, String paramString)
  {
    Object localObject2 = null;
    Iterator localIterator = null;
    if (paramGroupCatalogBean.b.equals(paramString)) {}
    do
    {
      for (Object localObject1 = paramGroupCatalogBean; !localIterator.hasNext(); localObject1 = localObject2)
      {
        do
        {
          do
          {
            return localObject1;
            localObject1 = localIterator;
          } while (paramGroupCatalogBean.jdField_a_of_type_JavaUtilArrayList == null);
          localObject1 = localIterator;
        } while (paramGroupCatalogBean.jdField_a_of_type_JavaUtilArrayList.isEmpty());
        localIterator = paramGroupCatalogBean.jdField_a_of_type_JavaUtilArrayList.iterator();
      }
      paramGroupCatalogBean = a((GroupCatalogBean)localIterator.next(), paramString);
      localObject1 = paramGroupCatalogBean;
    } while (paramGroupCatalogBean == null);
    return paramGroupCatalogBean;
  }
  
  private GroupCatalogBean a(String paramString)
  {
    Object localObject1 = null;
    if ((this.jdField_a_of_type_JavaUtilArrayList == null) || (this.jdField_a_of_type_JavaUtilArrayList.isEmpty())) {
      return null;
    }
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        GroupCatalogBean localGroupCatalogBean = a((GroupCatalogBean)localIterator.next(), paramString);
        localObject1 = localGroupCatalogBean;
        if (localGroupCatalogBean != null) {
          localObject1 = localGroupCatalogBean;
        }
      }
      return localObject1;
    }
  }
  
  public static GroupCatalogTool a(Context paramContext)
  {
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (jdField_a_of_type_ComTencentMobileqqTroopinfoGroupCatalogTool == null) {
        jdField_a_of_type_ComTencentMobileqqTroopinfoGroupCatalogTool = new GroupCatalogTool(paramContext);
      }
      return jdField_a_of_type_ComTencentMobileqqTroopinfoGroupCatalogTool;
    }
  }
  
  private String a(Context paramContext)
  {
    paramContext = paramContext.getFilesDir().getAbsolutePath() + File.separator + "group_catalog" + File.separator;
    File localFile = new File(paramContext);
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    return paramContext;
  }
  
  private ArrayList a(ArrayList paramArrayList, String paramString)
  {
    ArrayList localArrayList = null;
    GroupCatalogBean localGroupCatalogBean = null;
    Iterator localIterator;
    if (paramArrayList != null)
    {
      localIterator = paramArrayList.iterator();
      paramArrayList = localGroupCatalogBean;
    }
    for (;;)
    {
      localArrayList = paramArrayList;
      if (localIterator.hasNext())
      {
        localGroupCatalogBean = (GroupCatalogBean)localIterator.next();
        if ((localGroupCatalogBean.jdField_a_of_type_JavaUtilArrayList == null) || (localGroupCatalogBean.jdField_a_of_type_JavaUtilArrayList.size() <= 0)) {
          break label100;
        }
        if (!localGroupCatalogBean.b.equals(paramString)) {
          break label81;
        }
        localArrayList = localGroupCatalogBean.jdField_a_of_type_JavaUtilArrayList;
      }
      label81:
      label100:
      do
      {
        return localArrayList;
        localArrayList = a(localGroupCatalogBean.jdField_a_of_type_JavaUtilArrayList, paramString);
        paramArrayList = localArrayList;
        if (localArrayList == null) {
          break;
        }
        return localArrayList;
        localArrayList = paramArrayList;
      } while (localGroupCatalogBean.jdField_a_of_type_Int == 4);
    }
  }
  
  private GroupCatalogBean b(Context paramContext, String paramString)
  {
    if (!a()) {
      a(paramContext);
    }
    paramContext = new GroupCatalogXmlHandler(paramString);
    try
    {
      SAXParserFactory.newInstance().newSAXParser().parse(new InputSource(new InputStreamReader(new FileInputStream(this.jdField_a_of_type_JavaIoFile), "gb2312")), paramContext);
      this.jdField_a_of_type_JavaUtilArrayList = paramContext.a();
      paramContext = paramContext.a();
      return paramContext;
    }
    catch (FileNotFoundException paramContext)
    {
      paramContext.printStackTrace();
      return null;
    }
    catch (SAXException paramContext)
    {
      paramContext.printStackTrace();
      return null;
    }
    catch (IOException paramContext)
    {
      paramContext.printStackTrace();
      return null;
    }
    catch (ParserConfigurationException paramContext)
    {
      paramContext.printStackTrace();
    }
    return null;
  }
  
  public GroupCatalogBean a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqTroopinfoGroupCatalogBean;
  }
  
  public GroupCatalogBean a(Context paramContext, String paramString)
  {
    if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (!this.jdField_a_of_type_JavaUtilArrayList.isEmpty()))
    {
      paramContext = a(paramString);
      this.jdField_a_of_type_ComTencentMobileqqTroopinfoGroupCatalogBean = paramContext;
      return paramContext;
    }
    paramContext = b(paramContext, paramString);
    this.jdField_a_of_type_ComTencentMobileqqTroopinfoGroupCatalogBean = paramContext;
    return paramContext;
  }
  
  public ArrayList a()
  {
    return this.jdField_a_of_type_JavaUtilArrayList;
  }
  
  public ArrayList a(String paramString)
  {
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      paramString = a(this.jdField_a_of_type_JavaUtilArrayList, paramString);
      return paramString;
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList != null) {}
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      this.jdField_a_of_type_ComTencentMobileqqTroopinfoGroupCatalogBean = null;
      return;
    }
  }
  
  public void a(Context paramContext)
  {
    ZipUtil.a(paramContext, "layer.zip", a(paramContext));
  }
  
  public void a(GroupCatalogBean paramGroupCatalogBean)
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopinfoGroupCatalogBean = paramGroupCatalogBean;
  }
  
  public boolean a()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.jdField_a_of_type_JavaIoFile.exists())
    {
      bool1 = bool2;
      if (this.jdField_a_of_type_JavaIoFile.length() > 0L) {
        bool1 = true;
      }
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.troopinfo.GroupCatalogTool
 * JD-Core Version:    0.7.0.1
 */