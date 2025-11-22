def check_python():
    try:
        # 尝试导入一个Python标准库模块
        import sys
        return "python"
    except:
        # 若导入失败，说明没有找到Python环境
        return "not find python"

# 测试函数
print(check_python())