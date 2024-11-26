Aquí tienes un **README** simple pero efectivo para tu proyecto:

---

# Retrofit + Jetpack Compose App

Este proyecto es una aplicación de Android que utiliza **Jetpack Compose**, **Retrofit**, y **Coil** para mostrar información de países desde la API de [REST Countries](https://restcountries.com).

## Características

- Consumo de API REST para obtener datos de países.
- Interfaz de usuario moderna y responsiva con **Jetpack Compose**.
- Carga y caché de imágenes eficiente con **Coil**.
- Soporte para carga incremental con LazyColumn.

## Tecnologías Utilizadas

- **Kotlin**: Lenguaje de programación.
- **Jetpack Compose**: Para la construcción de la UI.
- **Retrofit**: Para consumir la API REST.
- **Coil**: Para la carga y caché de imágenes.
- **OkHttp**: Para la gestión de las solicitudes HTTP.

## Configuración

1. Clona el repositorio:
   ```bash
   git clone https://github.com/tu_usuario/tu_repositorio.git
   ```

2. Abre el proyecto en **Android Studio**.

3. Configura las dependencias (si no lo hace automáticamente):
   ```gradle
   ./gradlew build
   ```

4. Asegúrate de que tienes acceso a Internet en el emulador o dispositivo físico.

5. Ejecuta la aplicación:
   - Haz clic en **Run** o usa el atajo `Shift + F10`.

## Funcionalidad

1. **Pantalla de Lista de Países**:
   - Muestra una lista de países obtenidos desde la API.
   - Cada país incluye:
     - Nombre (en español, si está disponible).
     - Bandera.
     - Región.
     - Capital.

2. **Caché de Imágenes**:
   - Las imágenes de las banderas se cargan y almacenan en memoria y disco.
