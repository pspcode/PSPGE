# PSPGE
![pspcode](https://cdn.discordapp.com/attachments/1001900000726491278/1006306159428382750/1659992474170.png)
> PSPGE (Playstation Portable Game Environment) is a free api made for PSP game developers.

🐧 Owner: [@voidzzw999](https://github.com/voidzzw999)         
🎮 Discord: [discord.gg/pspcode](https://discord.gg/hrF8egHUVp)

✒️ Site: [https://pspcode.com]()      

Things added:
- [x] 🎮 **Gamepad Input**
- [x] 🎥 **Camera**
- [x] 🔊 **Sounds**
- [x] 🤖 **AI implementation**
- [x] 🐦 **Entities Manageament**
- [x] ⚓ **Texture Manageament** 
- [x] 🔡 **Font Manageament**
- [x] 🖱️ **Thread Manuser**
- [x] ⚙️ **Resources**  

# Graphics

🚖 The graphics library used in this api is the **OpenGL**. OpenGL (Open Graphics Library) is a free API used in computer graphics, for the development of graphics applications, 3D environments, games, among others. Like Direct3D or Glide, it is an Application Programming Interface (API), a term used to classify a library of specific functions made available for building and developing applications in certain programming languages. 
https://www.opengl.org

# Audio
🔊 The audio library used in this api is the **OpenAL**, OpenAL (Open Audio Library) é uma API livre e multiplataforma desenvolvida para lidar com audio multicanal tridimensional. É usado normalmente com OpenGL.
https://www.openal.org

# LWJGL
⚖️ The Lightweight Java Game Library (LWJGL) is an open-source software library that provides bindings to a variety of C libraries for video game developers to Java. It exposes cross-platform libraries commonly used in developing video games and multimedia titles, such as Vulkan, OpenGL, OpenAL and OpenCL.

The primary goal of the project is to provide a way for Java developers to get access to resources that are otherwise unavailable or poorly implemented on the existing Java platform. 
https://www.lwjgl.org
# Additional

🗂️ this framework will also be implemented in [Suffler Engine](https://github.com/sufflerengine), if you want to create more easily the engine will also have the ability to create games for PSP, because of our framework!

 * Things to add:
1. **Interface for creating projects** (In Development)
2. **Creation of Shaders** (GLSL File)
3. **Scenes** (2D & 3D)
4. **Export of 3D models** (+)

**Basic Application**

1. Create a class to be the engine class of your game.
```java
public class BasicGame { } 
```
2. Extend the Application class in its engine class.
```java
public class BasicGame extends Application { }
```
3. implement all the method.
```java
public class BasicGame extends Application {
  
    @Override
    public void onStart() {
    
    }
    
    @Override
    public void render() {
    
    }
    
    @Override 
    public void free() {
    
    }
}
```
 
# 💰 Donates Pathways

as a way to receive something in exchange for our api (of course it is completely free) we are leaving here our pathways of donations.
- 💸 Picpay: @macraum
- 💠 Pix (Mercado Pago): [@pspcode](1234aaa010@gmail.com)
- 🤑 Pix (PagSeguro): [@pspcode](32998626487)
