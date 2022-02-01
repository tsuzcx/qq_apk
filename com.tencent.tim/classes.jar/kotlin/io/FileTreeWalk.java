package kotlin.io;

import java.io.File;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin._Assertions;
import kotlin.collections.AbstractIterator;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/io/FileTreeWalk;", "Lkotlin/sequences/Sequence;", "Ljava/io/File;", "start", "direction", "Lkotlin/io/FileWalkDirection;", "(Ljava/io/File;Lkotlin/io/FileWalkDirection;)V", "onEnter", "Lkotlin/Function1;", "", "onLeave", "", "onFail", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "f", "Ljava/io/IOException;", "e", "maxDepth", "", "(Ljava/io/File;Lkotlin/io/FileWalkDirection;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;I)V", "iterator", "", "depth", "function", "DirectoryState", "FileTreeWalkIterator", "WalkState", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
public final class FileTreeWalk
  implements Sequence<File>
{
  private final FileWalkDirection direction;
  private final int maxDepth;
  private final Function1<File, Boolean> onEnter;
  private final Function2<File, IOException, Unit> onFail;
  private final Function1<File, Unit> onLeave;
  private final File start;
  
  public FileTreeWalk(@NotNull File paramFile, @NotNull FileWalkDirection paramFileWalkDirection)
  {
    this(paramFile, paramFileWalkDirection, null, null, null, 0, 32, null);
  }
  
  private FileTreeWalk(File paramFile, FileWalkDirection paramFileWalkDirection, Function1<? super File, Boolean> paramFunction1, Function1<? super File, Unit> paramFunction11, Function2<? super File, ? super IOException, Unit> paramFunction2, int paramInt)
  {
    this.start = paramFile;
    this.direction = paramFileWalkDirection;
    this.onEnter = paramFunction1;
    this.onLeave = paramFunction11;
    this.onFail = paramFunction2;
    this.maxDepth = paramInt;
  }
  
  @NotNull
  public Iterator<File> iterator()
  {
    return (Iterator)new FileTreeWalkIterator();
  }
  
  @NotNull
  public final FileTreeWalk maxDepth(int paramInt)
  {
    if (paramInt <= 0) {
      throw ((Throwable)new IllegalArgumentException("depth must be positive, but was " + paramInt + '.'));
    }
    return new FileTreeWalk(this.start, this.direction, this.onEnter, this.onLeave, this.onFail, paramInt);
  }
  
  @NotNull
  public final FileTreeWalk onEnter(@NotNull Function1<? super File, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramFunction1, "function");
    return new FileTreeWalk(this.start, this.direction, paramFunction1, this.onLeave, this.onFail, this.maxDepth);
  }
  
  @NotNull
  public final FileTreeWalk onFail(@NotNull Function2<? super File, ? super IOException, Unit> paramFunction2)
  {
    Intrinsics.checkParameterIsNotNull(paramFunction2, "function");
    return new FileTreeWalk(this.start, this.direction, this.onEnter, this.onLeave, paramFunction2, this.maxDepth);
  }
  
  @NotNull
  public final FileTreeWalk onLeave(@NotNull Function1<? super File, Unit> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramFunction1, "function");
    return new FileTreeWalk(this.start, this.direction, this.onEnter, paramFunction1, this.onFail, this.maxDepth);
  }
  
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/io/FileTreeWalk$DirectoryState;", "Lkotlin/io/FileTreeWalk$WalkState;", "rootDir", "Ljava/io/File;", "(Ljava/io/File;)V", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
  static abstract class DirectoryState
    extends FileTreeWalk.WalkState
  {
    public DirectoryState(@NotNull File paramFile)
    {
      super();
      if (_Assertions.ENABLED)
      {
        boolean bool = paramFile.isDirectory();
        if ((_Assertions.ENABLED) && (!bool)) {
          throw ((Throwable)new AssertionError("rootDir must be verified to be directory beforehand."));
        }
      }
    }
  }
  
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/io/FileTreeWalk$FileTreeWalkIterator;", "Lkotlin/collections/AbstractIterator;", "Ljava/io/File;", "(Lkotlin/io/FileTreeWalk;)V", "state", "Ljava/util/ArrayDeque;", "Lkotlin/io/FileTreeWalk$WalkState;", "computeNext", "", "directoryState", "Lkotlin/io/FileTreeWalk$DirectoryState;", "root", "gotoNext", "BottomUpDirectoryState", "SingleFileState", "TopDownDirectoryState", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
  final class FileTreeWalkIterator
    extends AbstractIterator<File>
  {
    private final ArrayDeque<FileTreeWalk.WalkState> state = new ArrayDeque();
    
    public FileTreeWalkIterator()
    {
      if (FileTreeWalk.access$getStart$p(this$1).isDirectory())
      {
        this.state.push(directoryState(FileTreeWalk.access$getStart$p(this$1)));
        return;
      }
      if (FileTreeWalk.access$getStart$p(this$1).isFile())
      {
        this.state.push(new SingleFileState(FileTreeWalk.access$getStart$p(this$1)));
        return;
      }
      done();
    }
    
    private final FileTreeWalk.DirectoryState directoryState(File paramFile)
    {
      FileWalkDirection localFileWalkDirection = FileTreeWalk.access$getDirection$p(this.this$0);
      switch (FileTreeWalk.FileTreeWalkIterator.WhenMappings.$EnumSwitchMapping$0[localFileWalkDirection.ordinal()])
      {
      default: 
        throw new NoWhenBranchMatchedException();
      case 1: 
        return (FileTreeWalk.DirectoryState)new TopDownDirectoryState(paramFile);
      }
      return (FileTreeWalk.DirectoryState)new BottomUpDirectoryState(paramFile);
    }
    
    private final File gotoNext()
    {
      for (;;)
      {
        FileTreeWalk.WalkState localWalkState = (FileTreeWalk.WalkState)this.state.peek();
        File localFile;
        if (localWalkState != null)
        {
          localFile = localWalkState.step();
          if (localFile == null) {
            this.state.pop();
          }
        }
        else
        {
          return null;
        }
        if ((Intrinsics.areEqual(localFile, localWalkState.getRoot())) || (!localFile.isDirectory()) || (this.state.size() >= FileTreeWalk.access$getMaxDepth$p(this.this$0))) {
          return localFile;
        }
        this.state.push(directoryState(localFile));
      }
    }
    
    public void computeNext()
    {
      File localFile = gotoNext();
      if (localFile != null)
      {
        setNext(localFile);
        return;
      }
      done();
    }
    
    @Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/io/FileTreeWalk$FileTreeWalkIterator$BottomUpDirectoryState;", "Lkotlin/io/FileTreeWalk$DirectoryState;", "rootDir", "Ljava/io/File;", "(Lkotlin/io/FileTreeWalk$FileTreeWalkIterator;Ljava/io/File;)V", "failed", "", "fileIndex", "", "fileList", "", "[Ljava/io/File;", "rootVisited", "step", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
    final class BottomUpDirectoryState
      extends FileTreeWalk.DirectoryState
    {
      private boolean failed;
      private int fileIndex;
      private File[] fileList;
      private boolean rootVisited;
      
      public BottomUpDirectoryState()
      {
        super();
      }
      
      @Nullable
      public File step()
      {
        if ((!this.failed) && (this.fileList == null))
        {
          localObject = FileTreeWalk.access$getOnEnter$p(FileTreeWalk.FileTreeWalkIterator.this.this$0);
          if ((localObject == null) || (((Boolean)((Function1)localObject).invoke(getRoot())).booleanValue())) {}
        }
        do
        {
          return null;
          this.fileList = getRoot().listFiles();
          if (this.fileList == null)
          {
            localObject = FileTreeWalk.access$getOnFail$p(FileTreeWalk.FileTreeWalkIterator.this.this$0);
            if (localObject != null) {
              localObject = (Unit)((Function2)localObject).invoke(getRoot(), new AccessDeniedException(getRoot(), null, "Cannot list files in a directory", 2, null));
            }
            this.failed = true;
          }
          if (this.fileList != null)
          {
            int i = this.fileIndex;
            localObject = this.fileList;
            if (localObject == null) {
              Intrinsics.throwNpe();
            }
            if (i < localObject.length)
            {
              localObject = this.fileList;
              if (localObject == null) {
                Intrinsics.throwNpe();
              }
              i = this.fileIndex;
              this.fileIndex = (i + 1);
              return localObject[i];
            }
          }
          if (!this.rootVisited)
          {
            this.rootVisited = true;
            return getRoot();
          }
          localObject = FileTreeWalk.access$getOnLeave$p(FileTreeWalk.FileTreeWalkIterator.this.this$0);
        } while (localObject == null);
        Object localObject = (Unit)((Function1)localObject).invoke(getRoot());
        return null;
      }
    }
    
    @Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/io/FileTreeWalk$FileTreeWalkIterator$SingleFileState;", "Lkotlin/io/FileTreeWalk$WalkState;", "rootFile", "Ljava/io/File;", "(Lkotlin/io/FileTreeWalk$FileTreeWalkIterator;Ljava/io/File;)V", "visited", "", "step", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
    final class SingleFileState
      extends FileTreeWalk.WalkState
    {
      private boolean visited;
      
      public SingleFileState()
      {
        super();
        if (_Assertions.ENABLED)
        {
          boolean bool = localObject.isFile();
          if ((_Assertions.ENABLED) && (!bool)) {
            throw ((Throwable)new AssertionError("rootFile must be verified to be file beforehand."));
          }
        }
      }
      
      @Nullable
      public File step()
      {
        if (this.visited) {
          return null;
        }
        this.visited = true;
        return getRoot();
      }
    }
    
    @Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/io/FileTreeWalk$FileTreeWalkIterator$TopDownDirectoryState;", "Lkotlin/io/FileTreeWalk$DirectoryState;", "rootDir", "Ljava/io/File;", "(Lkotlin/io/FileTreeWalk$FileTreeWalkIterator;Ljava/io/File;)V", "fileIndex", "", "fileList", "", "[Ljava/io/File;", "rootVisited", "", "step", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
    final class TopDownDirectoryState
      extends FileTreeWalk.DirectoryState
    {
      private int fileIndex;
      private File[] fileList;
      private boolean rootVisited;
      
      public TopDownDirectoryState()
      {
        super();
      }
      
      @Nullable
      public File step()
      {
        if (!this.rootVisited)
        {
          localObject = FileTreeWalk.access$getOnEnter$p(FileTreeWalk.FileTreeWalkIterator.this.this$0);
          if ((localObject == null) || (((Boolean)((Function1)localObject).invoke(getRoot())).booleanValue())) {}
        }
        label236:
        do
        {
          do
          {
            return null;
            this.rootVisited = true;
            return getRoot();
            if (this.fileList != null)
            {
              i = this.fileIndex;
              localObject = this.fileList;
              if (localObject == null) {
                Intrinsics.throwNpe();
              }
              if (i >= localObject.length) {
                break label236;
              }
            }
            if (this.fileList != null) {
              break;
            }
            this.fileList = getRoot().listFiles();
            if (this.fileList == null)
            {
              localObject = FileTreeWalk.access$getOnFail$p(FileTreeWalk.FileTreeWalkIterator.this.this$0);
              if (localObject != null) {
                localObject = (Unit)((Function2)localObject).invoke(getRoot(), new AccessDeniedException(getRoot(), null, "Cannot list files in a directory", 2, null));
              }
            }
            if (this.fileList != null)
            {
              localObject = this.fileList;
              if (localObject == null) {
                Intrinsics.throwNpe();
              }
              if (localObject.length != 0) {
                break;
              }
            }
            localObject = FileTreeWalk.access$getOnLeave$p(FileTreeWalk.FileTreeWalkIterator.this.this$0);
          } while (localObject == null);
          localObject = (Unit)((Function1)localObject).invoke(getRoot());
          return null;
          localObject = this.fileList;
          if (localObject == null) {
            Intrinsics.throwNpe();
          }
          int i = this.fileIndex;
          this.fileIndex = (i + 1);
          return localObject[i];
          localObject = FileTreeWalk.access$getOnLeave$p(FileTreeWalk.FileTreeWalkIterator.this.this$0);
        } while (localObject == null);
        Object localObject = (Unit)((Function1)localObject).invoke(getRoot());
        return null;
      }
    }
  }
  
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/io/FileTreeWalk$WalkState;", "", "root", "Ljava/io/File;", "(Ljava/io/File;)V", "getRoot", "()Ljava/io/File;", "step", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
  static abstract class WalkState
  {
    @NotNull
    private final File root;
    
    public WalkState(@NotNull File paramFile)
    {
      this.root = paramFile;
    }
    
    @NotNull
    public final File getRoot()
    {
      return this.root;
    }
    
    @Nullable
    public abstract File step();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kotlin.io.FileTreeWalk
 * JD-Core Version:    0.7.0.1
 */