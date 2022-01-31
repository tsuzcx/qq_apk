package android.support.v4.graphics;

import android.graphics.Path;
import android.support.annotation.RestrictTo;
import java.util.ArrayList;

@RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
public class PathParser
{
  private static final String LOGTAG = "PathParser";
  
  private static void addNode(ArrayList paramArrayList, char paramChar, float[] paramArrayOfFloat)
  {
    paramArrayList.add(new PathParser.PathDataNode(paramChar, paramArrayOfFloat));
  }
  
  public static boolean canMorph(PathParser.PathDataNode[] paramArrayOfPathDataNode1, PathParser.PathDataNode[] paramArrayOfPathDataNode2)
  {
    if ((paramArrayOfPathDataNode1 == null) || (paramArrayOfPathDataNode2 == null)) {}
    while (paramArrayOfPathDataNode1.length != paramArrayOfPathDataNode2.length) {
      return false;
    }
    int i = 0;
    for (;;)
    {
      if (i >= paramArrayOfPathDataNode1.length) {
        break label64;
      }
      if ((paramArrayOfPathDataNode1[i].mType != paramArrayOfPathDataNode2[i].mType) || (paramArrayOfPathDataNode1[i].mParams.length != paramArrayOfPathDataNode2[i].mParams.length)) {
        break;
      }
      i += 1;
    }
    label64:
    return true;
  }
  
  static float[] copyOfRange(float[] paramArrayOfFloat, int paramInt1, int paramInt2)
  {
    if (paramInt1 > paramInt2) {
      throw new IllegalArgumentException();
    }
    int i = paramArrayOfFloat.length;
    if ((paramInt1 < 0) || (paramInt1 > i)) {
      throw new ArrayIndexOutOfBoundsException();
    }
    paramInt2 -= paramInt1;
    i = Math.min(paramInt2, i - paramInt1);
    float[] arrayOfFloat = new float[paramInt2];
    System.arraycopy(paramArrayOfFloat, paramInt1, arrayOfFloat, 0, i);
    return arrayOfFloat;
  }
  
  public static PathParser.PathDataNode[] createNodesFromPathData(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    int j = 1;
    int i = 0;
    while (j < paramString.length())
    {
      j = nextStart(paramString, j);
      String str = paramString.substring(i, j).trim();
      if (str.length() > 0)
      {
        float[] arrayOfFloat = getFloats(str);
        addNode(localArrayList, str.charAt(0), arrayOfFloat);
      }
      int k = j + 1;
      i = j;
      j = k;
    }
    if ((j - i == 1) && (i < paramString.length())) {
      addNode(localArrayList, paramString.charAt(i), new float[0]);
    }
    return (PathParser.PathDataNode[])localArrayList.toArray(new PathParser.PathDataNode[localArrayList.size()]);
  }
  
  public static Path createPathFromPathData(String paramString)
  {
    Path localPath = new Path();
    PathParser.PathDataNode[] arrayOfPathDataNode = createNodesFromPathData(paramString);
    if (arrayOfPathDataNode != null) {
      try
      {
        PathParser.PathDataNode.nodesToPath(arrayOfPathDataNode, localPath);
        return localPath;
      }
      catch (RuntimeException localRuntimeException)
      {
        throw new RuntimeException("Error in parsing " + paramString, localRuntimeException);
      }
    }
    return null;
  }
  
  public static PathParser.PathDataNode[] deepCopyNodes(PathParser.PathDataNode[] paramArrayOfPathDataNode)
  {
    if (paramArrayOfPathDataNode == null) {
      return null;
    }
    PathParser.PathDataNode[] arrayOfPathDataNode = new PathParser.PathDataNode[paramArrayOfPathDataNode.length];
    int i = 0;
    while (i < paramArrayOfPathDataNode.length)
    {
      arrayOfPathDataNode[i] = new PathParser.PathDataNode(paramArrayOfPathDataNode[i]);
      i += 1;
    }
    return arrayOfPathDataNode;
  }
  
  private static void extract(String paramString, int paramInt, PathParser.ExtractFloatResult paramExtractFloatResult)
  {
    paramExtractFloatResult.mEndWithNegOrDot = false;
    int i = 0;
    int m = 0;
    int j = 0;
    int k = paramInt;
    for (;;)
    {
      if (k < paramString.length()) {
        switch (paramString.charAt(k))
        {
        default: 
          i = 0;
        }
      }
      for (;;)
      {
        if (j == 0) {
          break label164;
        }
        paramExtractFloatResult.mEndPosition = k;
        return;
        i = 0;
        j = 1;
        continue;
        if ((k == paramInt) || (i != 0)) {
          break;
        }
        paramExtractFloatResult.mEndWithNegOrDot = true;
        i = 0;
        j = 1;
        continue;
        if (m == 0)
        {
          i = 0;
          m = 1;
        }
        else
        {
          paramExtractFloatResult.mEndWithNegOrDot = true;
          i = 0;
          j = 1;
          continue;
          i = 1;
        }
      }
      label164:
      k += 1;
    }
  }
  
  private static float[] getFloats(String paramString)
  {
    int i = 0;
    if ((paramString.charAt(0) == 'z') || (paramString.charAt(0) == 'Z')) {
      return new float[0];
    }
    for (;;)
    {
      int k;
      try
      {
        float[] arrayOfFloat = new float[paramString.length()];
        PathParser.ExtractFloatResult localExtractFloatResult = new PathParser.ExtractFloatResult();
        int n = paramString.length();
        j = 1;
        if (j < n)
        {
          extract(paramString, j, localExtractFloatResult);
          k = localExtractFloatResult.mEndPosition;
          if (j < k)
          {
            int m = i + 1;
            arrayOfFloat[i] = Float.parseFloat(paramString.substring(j, k));
            i = m;
            if (!localExtractFloatResult.mEndWithNegOrDot) {
              break label160;
            }
            j = k;
          }
        }
        else
        {
          arrayOfFloat = copyOfRange(arrayOfFloat, 0, i);
          return arrayOfFloat;
        }
      }
      catch (NumberFormatException localNumberFormatException)
      {
        throw new RuntimeException("error in parsing \"" + paramString + "\"", localNumberFormatException);
      }
      continue;
      label160:
      int j = k + 1;
    }
  }
  
  private static int nextStart(String paramString, int paramInt)
  {
    for (;;)
    {
      if (paramInt < paramString.length())
      {
        int i = paramString.charAt(paramInt);
        if ((((i - 65) * (i - 90) > 0) && ((i - 97) * (i - 122) > 0)) || (i == 101) || (i == 69)) {}
      }
      else
      {
        return paramInt;
      }
      paramInt += 1;
    }
  }
  
  public static void updateNodes(PathParser.PathDataNode[] paramArrayOfPathDataNode1, PathParser.PathDataNode[] paramArrayOfPathDataNode2)
  {
    int i = 0;
    while (i < paramArrayOfPathDataNode2.length)
    {
      paramArrayOfPathDataNode1[i].mType = paramArrayOfPathDataNode2[i].mType;
      int j = 0;
      while (j < paramArrayOfPathDataNode2[i].mParams.length)
      {
        paramArrayOfPathDataNode1[i].mParams[j] = paramArrayOfPathDataNode2[i].mParams[j];
        j += 1;
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v4.graphics.PathParser
 * JD-Core Version:    0.7.0.1
 */