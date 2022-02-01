package com.tencent.tgpa.vendorpd.a;

import android.util.Log;
import java.io.File;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

public class b
{
  private ArrayList<a> a;
  private String b;
  
  public b(String paramString)
  {
    this.b = paramString;
  }
  
  private boolean a(a parama)
  {
    try
    {
      RandomAccessFile localRandomAccessFile = new RandomAccessFile(new File(this.b), "rw");
      long l1 = localRandomAccessFile.length();
      long l2 = parama.c;
      int i = parama.d;
      parama = d.c(parama.e);
      if (parama.length != i)
      {
        Log.e("TGPA", "cloud operation's content size is not matched, ple check it.");
        return false;
      }
      localRandomAccessFile.seek(l1 - l2);
      localRandomAccessFile.write(parama, 0, i);
      localRandomAccessFile.close();
      return true;
    }
    catch (Exception parama)
    {
      parama.printStackTrace();
      Log.e("TGPA", "can not modify predownload file content.");
    }
    return false;
  }
  
  private boolean b(a parama)
  {
    Log.d("TGPA", "can not delete predownload file content.");
    return false;
  }
  
  private boolean c(a parama)
  {
    Log.e("TGPA", "use modify instead of insert predownload file content.");
    return a(parama);
  }
  
  public boolean a()
  {
    if (this.b == null) {
      return false;
    }
    if ((this.a == null) || (this.a.size() <= 0)) {
      return false;
    }
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      a locala = (a)localIterator.next();
      if (locala.b.equals("insert"))
      {
        if (!c(locala)) {
          return false;
        }
      }
      else if (locala.b.equals("delete"))
      {
        if (!b(locala)) {
          return false;
        }
      }
      else if ((locala.b.equals("modify")) && (!a(locala))) {
        return false;
      }
    }
    return true;
  }
  
  public boolean a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {}
    do
    {
      do
      {
        return false;
      } while (!paramJSONObject.has("alter_list"));
      paramJSONObject = paramJSONObject.optJSONArray("alter_list");
    } while ((paramJSONObject == null) && (paramJSONObject.length() <= 0));
    this.a = new ArrayList();
    int j = paramJSONObject.length();
    int i = 0;
    for (;;)
    {
      if (i >= j) {
        break label140;
      }
      JSONObject localJSONObject = paramJSONObject.optJSONObject(i);
      if ((localJSONObject == null) || (localJSONObject.optInt("index") != i)) {
        break;
      }
      a locala = new a();
      if (!locala.a(localJSONObject))
      {
        m.b("File operation parse exception, index: " + i);
        return false;
      }
      this.a.add(locala);
      i += 1;
    }
    label140:
    return true;
  }
  
  public class a
  {
    public int a;
    public String b;
    public long c;
    public int d;
    public String e;
    
    public a() {}
    
    public boolean a(JSONObject paramJSONObject)
    {
      if (!paramJSONObject.has("index")) {}
      while ((!paramJSONObject.has("action")) || (!paramJSONObject.has("offset")) || (!paramJSONObject.has("size")) || (!paramJSONObject.has("content"))) {
        return false;
      }
      try
      {
        this.a = paramJSONObject.getInt("index");
        this.b = paramJSONObject.getString("action");
        this.c = paramJSONObject.getLong("offset");
        this.d = paramJSONObject.getInt("size");
        this.e = paramJSONObject.getString("content");
        return true;
      }
      catch (Exception paramJSONObject)
      {
        paramJSONObject.printStackTrace();
      }
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tgpa.vendorpd.a.b
 * JD-Core Version:    0.7.0.1
 */