图　　在File类中包含了大部分和文件操作的功能方法，该类的对象可以代表一个具体的文件或文件夹，所以以前曾有人建议将该类的类名修改成FilePath，因为该类也可以代表一个文件夹，更准确的说是可以代表一个文件路径。
1、创建文件
1）boolean java.io.File.createNewFile() throws IOException用来创建文件，如果文件存在，创建失败，返回false；
2）new File("a.txt");并不创建文件实体，只是创建一个指向“a.txt”的引用。
3）路径分隔符：File.separator
 
2、删除文件
1）delete()：删除文件成功返回true，删除失败返回false（ boolean java.io.File.delete()  ）
2）deleteOnExit()：程序退出时，自动删除文件。一般用于对程序创建的临时文件进行操作，退出时删除。（ void java.io.File.deleteOnExit()  ）
 
3、判断文件是否存在
exists()：判断文件是否存在（ boolean java.io.File.exists() ）
 
4、创建文件夹
1）mkdir()：只能创建“一级目录”（boolean java.io.File.mkdir()）；
2）mkdirs()：可以创建多级目录（boolean java.io.File.mkdirs()）。
 
5、文件类型判断
1）exists()：判断文件是否存在，注意：一定要先判断这个；
2）isDirectory()：判断是否为文件夹；
3）isFile()：判断是否为文件；
4）isHidden()：判断是否为隐藏文件；
5）isAbsolute()：判断是否为绝对路径，这里不管文件是否存在都能判断。
 
6、获取文件信息
1）getName()：获取文件名；
2）getParent()：获取文件父目录；
3）getPath()：获取文件路径；
4）getAbsolutePath()：获取文件绝对路径；
5）lastModified()：获得文件最后一次被修改的时间；
6）length()：获取文件大小；
7）renameTo()：文件剪切，将文件f1剪切然后粘贴到f2（相当于右键f1->剪切->粘贴->f2所在目录）
 
7、获取目录下文件名
1）listRoots()：获取系统盘符；
2）list()：获取“X:\\”目录下的所有文件名，包括隐藏文件和文件夹（调用list()方法时，必须先封装一个目录，且必须存在的目录。）
3）list(FilenameFilter filter)：列出文件名的时候，可以进行过滤操作（如：列出后缀名为.txt的文件）。
4）listFiles()：列出目录下文件名，不包括文件夹。
5）listFiles(FileFileter filter)，列出文件，过滤。
过滤接口：FileNameFileter  FileFileter
隐藏文件不能写。

关于IO流只有一张图可以表示
![](https://ae01.alicdn.com/kf/Hc07eec0057bb44cf84234a5ce23ad945N.png)
