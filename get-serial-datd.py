import serial

ser = serial.Serial('COM5', 9600) # 将COM3替换为你的串口号

while True:
    data = ser.readline().decode('utf-8').rstrip()
    # 读取串口数据，解码为字符串并去除末尾的换行符
    print(data) # 打印读取到的数据
