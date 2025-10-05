import pandas as pd
import matplotlib.pyplot as plt
import os

# Чтение CSV
data = pd.read_csv("docs/performance-plots/data.csv")
output_dir = "docs/performance-plots"

# Сравнения vs n
plt.figure(figsize=(8, 6))
plt.plot(data['n'], data['comparisons'], marker='o', linestyle='-')
plt.title('Comparisons vs n')
plt.xlabel('Array size n')
plt.ylabel('Number of comparisons')
plt.grid(True)
plt.savefig(os.path.join(output_dir, "comparisons_vs_n.png"))
plt.close()

# Доступы к массиву vs n
plt.figure(figsize=(8, 6))
plt.plot(data['n'], data['array_accesses'], marker='o', linestyle='-', color='orange')
plt.title('Array Accesses vs n')
plt.xlabel('Array size n')
plt.ylabel('Number of array accesses')
plt.grid(True)
plt.savefig(os.path.join(output_dir, "array_accesses_vs_n.png"))
plt.close()

# Время vs n
plt.figure(figsize=(8, 6))
plt.plot(data['n'], data['time_ms'], marker='o', linestyle='-', color='green')
plt.title('Execution Time vs n')
plt.xlabel('Array size n')
plt.ylabel('Time (ms)')
plt.grid(True)
plt.savefig(os.path.join(output_dir, "time_vs_n.png"))
plt.close()

print("Графики сохранены: comparisons_vs_n.png, array_accesses_vs_n.png, time_vs_n.png")
