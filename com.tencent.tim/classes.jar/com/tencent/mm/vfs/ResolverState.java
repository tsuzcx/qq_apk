package com.tencent.mm.vfs;

import android.os.Bundle;
import android.os.Parcelable;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Map<Ljava.lang.String;Lcom.tencent.mm.vfs.SchemeResolver;>;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedMap<Ljava.lang.String;Ljava.lang.String;>;
import java.util.TreeMap;

final class ResolverState
  implements SchemeResolver.ResolverContext
{
  private static final FileSystem DEFAULT_ROOT = new NativeFileSystem("", false);
  private static final String TAG = "VFS.ResolverState";
  final List<MountPointEntry> mActiveMountPoints;
  private Map<String, String> mEnvSnapshot = null;
  final Map<String, String> mEnvVars;
  final Map<String, FileSystem> mFileSystems;
  private Map<String, FileSystem> mFileSystemsSnapshot = null;
  final SortedMap<String, String> mMountPoints;
  final FileSystem mRootFileSystem;
  final Map<String, SchemeResolver> mSchemeResolvers;
  
  ResolverState()
  {
    this.mSchemeResolvers = Collections.emptyMap();
    this.mFileSystems = Collections.emptyMap();
    this.mMountPoints = new TreeMap();
    this.mActiveMountPoints = Collections.emptyList();
    this.mEnvVars = Collections.emptyMap();
    this.mRootFileSystem = DEFAULT_ROOT;
  }
  
  private ResolverState(Map<String, SchemeResolver> paramMap, Map<String, FileSystem> paramMap1, SortedMap<String, String> paramSortedMap, Map<String, String> paramMap2, FileSystem paramFileSystem)
  {
    this.mSchemeResolvers = paramMap;
    this.mFileSystems = paramMap1;
    this.mMountPoints = paramSortedMap;
    this.mActiveMountPoints = generateMountPoints(paramMap1, paramSortedMap, paramMap2);
    this.mEnvVars = paramMap2;
    paramMap = paramFileSystem;
    if (paramFileSystem == null) {
      paramMap = DEFAULT_ROOT;
    }
    this.mRootFileSystem = paramMap;
  }
  
  private static List<MountPointEntry> generateMountPoints(Map<String, FileSystem> paramMap, SortedMap<String, String> paramSortedMap, Map<String, String> paramMap1)
  {
    VFSTrack.track(null, "generateMountPoints");
    ArrayList localArrayList = new ArrayList(paramSortedMap.size());
    paramSortedMap = paramSortedMap.entrySet().iterator();
    while (paramSortedMap.hasNext())
    {
      Object localObject = (Map.Entry)paramSortedMap.next();
      String str = (String)((Map.Entry)localObject).getKey();
      localObject = (String)((Map.Entry)localObject).getValue();
      FileSystem localFileSystem = (FileSystem)paramMap.get(localObject);
      if (localFileSystem == null) {
        throw new IllegalArgumentException("FileSystem '" + (String)localObject + "' for mount point '" + str + "' not exist.");
      }
      str = VFSUtils.macroResolve(str, paramMap1);
      if (str != null) {
        localArrayList.add(new MountPointEntry(str, (String)localObject, localFileSystem, -1));
      }
    }
    paramMap = (MountPointEntry[])localArrayList.toArray(new MountPointEntry[0]);
    Arrays.sort(paramMap, new ResolverState.1());
    int j = 1;
    if (j < paramMap.length)
    {
      paramSortedMap = paramMap[j];
      paramMap1 = paramSortedMap.basePath;
      int i = j - 1;
      localArrayList = paramMap[i];
      if (paramSortedMap.basePath.equals(localArrayList.basePath)) {
        if (QLog.isColorLevel()) {
          QLog.w("VFS.ResolverState", 2, "Oops, duplicated mount point detected: " + paramSortedMap.toString() + " <=> " + localArrayList.toString());
        }
      }
      int k;
      for (i = localArrayList.fallbackIndex;; i = k)
      {
        if (i >= 0) {
          paramMap[j] = new MountPointEntry(paramSortedMap.basePath, paramSortedMap.fileSystemName, paramSortedMap.fileSystem, i);
        }
        j += 1;
        break;
        do
        {
          localArrayList = paramMap[i];
          if ((paramMap1.startsWith(localArrayList.basePath)) && (paramMap1.charAt(localArrayList.basePath.length()) == '/')) {
            break;
          }
          k = localArrayList.fallbackIndex;
          i = k;
        } while (k >= 0);
      }
    }
    VFSTrack.track("generateMountPoints", null);
    return Arrays.asList(paramMap);
  }
  
  static ResolverState loadFromBundle(Bundle paramBundle)
  {
    VFSTrack.track(null, "load_bundle");
    Object localObject1 = paramBundle.getParcelableArrayList("sl");
    Object localObject2 = paramBundle.getBundle("sm");
    HashMap localHashMap = new HashMap();
    if ((localObject1 != null) && (localObject2 != null))
    {
      localObject3 = ((Bundle)localObject2).keySet().iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localObject4 = (String)((Iterator)localObject3).next();
        int i = ((Bundle)localObject2).getInt((String)localObject4);
        if ((i >= 0) && (i < ((ArrayList)localObject1).size())) {
          localHashMap.put(localObject4, ((ArrayList)localObject1).get(i));
        }
      }
    }
    localObject2 = paramBundle.getBundle("fs");
    localObject1 = new HashMap();
    if (localObject2 != null)
    {
      ((Bundle)localObject2).setClassLoader(paramBundle.getClassLoader());
      localObject3 = ((Bundle)localObject2).keySet().iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localObject4 = (String)((Iterator)localObject3).next();
        ((HashMap)localObject1).put(localObject4, ((Bundle)localObject2).getParcelable((String)localObject4));
      }
    }
    Object localObject3 = paramBundle.getBundle("mp");
    localObject2 = new TreeMap();
    Object localObject5;
    if (localObject3 != null)
    {
      ((Bundle)localObject3).setClassLoader(paramBundle.getClassLoader());
      localObject4 = ((Bundle)localObject3).keySet().iterator();
      while (((Iterator)localObject4).hasNext())
      {
        localObject5 = (String)((Iterator)localObject4).next();
        ((TreeMap)localObject2).put(localObject5, ((Bundle)localObject3).getString((String)localObject5));
      }
    }
    Object localObject4 = paramBundle.getBundle("env");
    localObject3 = new HashMap();
    if (localObject4 != null)
    {
      localObject5 = ((Bundle)localObject4).keySet().iterator();
      while (((Iterator)localObject5).hasNext())
      {
        String str = (String)((Iterator)localObject5).next();
        ((HashMap)localObject3).put(str, ((Bundle)localObject4).getString(str));
      }
    }
    paramBundle = (FileSystem)paramBundle.getParcelable("root");
    VFSTrack.track("load_bundle", null);
    return new ResolverState(localHashMap, (Map)localObject1, (SortedMap)localObject2, (Map)localObject3, paramBundle);
  }
  
  private static <K, V> void mergeMap(Map<K, V> paramMap1, Map<K, V> paramMap2)
  {
    paramMap2 = paramMap2.entrySet().iterator();
    while (paramMap2.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMap2.next();
      if (localEntry.getValue() == null) {
        paramMap1.remove(localEntry.getKey());
      } else {
        paramMap1.put(localEntry.getKey(), localEntry.getValue());
      }
    }
  }
  
  public SortedMap<String, FileSystem> activeMountPoints()
  {
    return null;
  }
  
  public Map<String, String> envVars()
  {
    if (this.mEnvSnapshot == null) {
      this.mEnvSnapshot = Collections.unmodifiableMap(this.mEnvVars);
    }
    return this.mEnvSnapshot;
  }
  
  public Map<String, FileSystem> fileSystems()
  {
    if (this.mFileSystemsSnapshot == null) {
      this.mFileSystemsSnapshot = Collections.unmodifiableMap(this.mFileSystems);
    }
    return this.mFileSystemsSnapshot;
  }
  
  public FileSystem root()
  {
    return this.mRootFileSystem;
  }
  
  public String toString()
  {
    return "schemes: " + this.mSchemeResolvers.size() + ", fileSystems: " + this.mFileSystems.size() + ", mountPoints: " + this.mMountPoints.size() + " (" + this.mActiveMountPoints + " active), envVars: " + this.mEnvVars.size();
  }
  
  ResolverState update(Map<String, SchemeResolver> paramMap, Map<String, FileSystem> paramMap1, SortedMap<String, String> paramSortedMap, Map<String, String> paramMap2, FileSystem paramFileSystem)
  {
    VFSTrack.track(null, "update");
    int i = 0;
    Object localObject1;
    label39:
    label53:
    Object localObject2;
    if (paramMap.isEmpty())
    {
      paramMap = this.mSchemeResolvers;
      if (!paramMap1.isEmpty()) {
        break label173;
      }
      localObject1 = this.mFileSystems;
      if (!paramSortedMap.isEmpty()) {
        break label198;
      }
      paramSortedMap = this.mMountPoints;
      if (!paramMap2.isEmpty()) {
        break label226;
      }
      localObject2 = this.mEnvVars;
      label69:
      if (paramFileSystem != null) {
        break label252;
      }
      paramFileSystem = this.mRootFileSystem;
      label80:
      if (i == 0) {
        break label255;
      }
    }
    label173:
    label198:
    label226:
    label252:
    label255:
    for (paramMap = new ResolverState(paramMap, (Map)localObject1, paramSortedMap, (Map)localObject2, paramFileSystem);; paramMap = this)
    {
      if (paramMap1.isEmpty()) {
        paramMap.mFileSystemsSnapshot = this.mFileSystemsSnapshot;
      }
      if (paramMap2.isEmpty()) {
        paramMap.mEnvSnapshot = this.mEnvSnapshot;
      }
      VFSTrack.track("update", null);
      return paramMap;
      localObject1 = new HashMap(this.mSchemeResolvers);
      mergeMap((Map)localObject1, paramMap);
      i = 1;
      paramMap = (Map<String, SchemeResolver>)localObject1;
      break;
      localObject1 = new HashMap(this.mFileSystems);
      mergeMap((Map)localObject1, paramMap1);
      i = 1;
      break label39;
      localObject2 = new TreeMap(this.mMountPoints);
      mergeMap((Map)localObject2, paramSortedMap);
      i = 1;
      paramSortedMap = (SortedMap<String, String>)localObject2;
      break label53;
      localObject2 = new HashMap(this.mEnvVars);
      mergeMap((Map)localObject2, paramMap2);
      i = 1;
      break label69;
      break label80;
    }
  }
  
  Bundle writeToBundle()
  {
    VFSTrack.track(null, "writeToBundle");
    Bundle localBundle1 = new Bundle();
    Object localObject3 = new HashMap();
    ArrayList localArrayList = new ArrayList(this.mSchemeResolvers.size());
    Bundle localBundle2 = new Bundle();
    Iterator localIterator = this.mSchemeResolvers.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      SchemeResolver localSchemeResolver = (SchemeResolver)localEntry.getValue();
      localObject2 = (Integer)((HashMap)localObject3).get(localSchemeResolver);
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = Integer.valueOf(localArrayList.size());
        localArrayList.add(localSchemeResolver);
        ((HashMap)localObject3).put(localSchemeResolver, localObject1);
      }
      localBundle2.putInt((String)localEntry.getKey(), ((Integer)localObject1).intValue());
    }
    localBundle1.putParcelableArrayList("sl", localArrayList);
    localBundle1.putBundle("sm", localBundle2);
    Object localObject1 = new Bundle();
    Object localObject2 = this.mFileSystems.entrySet().iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (Map.Entry)((Iterator)localObject2).next();
      ((Bundle)localObject1).putParcelable((String)((Map.Entry)localObject3).getKey(), (Parcelable)((Map.Entry)localObject3).getValue());
    }
    localBundle1.putBundle("fs", (Bundle)localObject1);
    localObject1 = new Bundle();
    localObject2 = this.mMountPoints.entrySet().iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (Map.Entry)((Iterator)localObject2).next();
      ((Bundle)localObject1).putString((String)((Map.Entry)localObject3).getKey(), (String)((Map.Entry)localObject3).getValue());
    }
    localBundle1.putBundle("mp", (Bundle)localObject1);
    localObject1 = new Bundle();
    localObject2 = this.mEnvVars.entrySet().iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (Map.Entry)((Iterator)localObject2).next();
      ((Bundle)localObject1).putString((String)((Map.Entry)localObject3).getKey(), (String)((Map.Entry)localObject3).getValue());
    }
    localBundle1.putBundle("env", (Bundle)localObject1);
    localBundle1.putParcelable("root", this.mRootFileSystem);
    VFSTrack.track("writeToBundle", null);
    return localBundle1;
  }
  
  static final class MountPointEntry
    implements Comparable<String>
  {
    final String basePath;
    final int fallbackIndex;
    final FileSystem fileSystem;
    final String fileSystemName;
    
    MountPointEntry(String paramString1, String paramString2, FileSystem paramFileSystem, int paramInt)
    {
      this.basePath = paramString1;
      this.fileSystemName = paramString2;
      this.fileSystem = paramFileSystem;
      this.fallbackIndex = paramInt;
    }
    
    public int compareTo(String paramString)
    {
      return this.basePath.compareTo(paramString);
    }
    
    public String toString()
    {
      return this.basePath + " -> " + this.fileSystemName + " " + this.fileSystem.toString();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mm.vfs.ResolverState
 * JD-Core Version:    0.7.0.1
 */